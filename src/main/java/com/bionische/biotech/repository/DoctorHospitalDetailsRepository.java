package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.DoctorHospitalDetails;

public interface DoctorHospitalDetailsRepository extends JpaRepository<DoctorHospitalDetails, Long>{

	DoctorHospitalDetails save(DoctorHospitalDetails doctorHospitalDetails);
	
	
}
