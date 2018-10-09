package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorNotification;

public interface DoctorNotificationRepository extends JpaRepository<DoctorNotification, Integer>{

	DoctorNotification save(DoctorNotification doctorNotification);
	List<DoctorNotification> findFirst20ByDoctorIdOrderByNotificationIdDesc(int doctorId);
	List<DoctorNotification> findFirst100ByDoctorIdOrderByNotificationIdDesc(int doctorId);
	@Transactional
	@Modifying
	@Query("UPDATE DoctorNotification  SET status =:status WHERE notificationId=:notificationId")
	int updateNotificationStatus(@Param("notificationId")int notificationId, @Param("status")int status);
 
	
}
