package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.DoctorHospitalDetails;
import com.bionische.biotech.model.GetHospitalDetails;

public interface DoctorHospitalDetailsRepository extends JpaRepository<DoctorHospitalDetails, Long>{

	DoctorHospitalDetails save(DoctorHospitalDetails doctorHospitalDetails);
	
	
	
}
