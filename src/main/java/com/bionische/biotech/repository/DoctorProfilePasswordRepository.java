package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.DoctorProfilePassword;

public interface DoctorProfilePasswordRepository extends JpaRepository<DoctorProfilePassword, Integer>{

	
	DoctorProfilePassword save(DoctorProfilePassword doctorProfilePassword);
	
	DoctorProfilePassword findByDoctorId(int doctorId);
}
