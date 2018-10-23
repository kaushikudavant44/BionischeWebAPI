package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.PatientNotification;

public interface PatientNotificationRepository extends JpaRepository<PatientNotification, Integer>{

	PatientNotification save(PatientNotification doctorNotification);
	List<PatientNotification> findFirst20ByPatientIdOrderByNotificationIdDesc(int patientId);
	List<PatientNotification> findFirst100ByPatientIdOrderByNotificationIdDesc(int patientId);
	@Transactional
	@Modifying
	@Query("UPDATE PatientNotification  SET status =:status WHERE notificationId=:notificationId")
	int updateNotificationStatus(@Param("notificationId")int notificationId, @Param("status")int status);
	
	@Transactional
	@Modifying
	@Query("DELETE PatientNotification  WHERE notificationId=:notificationId")
	int updateDoneRating(@Param("notificationId")int notificationId);
	
	@Transactional
	@Modifying
	@Query("UPDATE PatientNotification SET string2 =:status WHERE notificationId=:notificationId")
	int updateLabDoneRating(@Param("notificationId")int notificationId, @Param("status")String status);
 
}
