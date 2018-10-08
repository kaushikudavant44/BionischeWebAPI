package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.DoctorNotification;

public interface DoctorNotificationRepository extends JpaRepository<DoctorNotification, Integer>{

	DoctorNotification save(DoctorNotification doctorNotification);
	List<DoctorNotification> findFirst20ByDoctorIdOrderByNotificationIdDesc(int doctorId);
	List<DoctorNotification> findFirst100ByDoctorIdOrderByNotificationIdDesc(int doctorId);
	
}
