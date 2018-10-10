package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorNotification;
import com.bionische.biotech.model.LabNotification;


public interface LabNotificationRepository extends JpaRepository<LabNotification, Integer>{

	LabNotification save(LabNotification labNotification);
	List<LabNotification> findFirst20ByLabIdOrderByNotificationIdDesc(int labId);
	List<LabNotification> findFirst100ByLabIdOrderByNotificationIdDesc(int labId);

	@Transactional
	@Modifying
	@Query("UPDATE LabNotification  SET status =:status WHERE notificationId=:notificationId")
	int updateLabNotificationStatus(@Param("notificationId")int notificationId, @Param("status")int status);
}
