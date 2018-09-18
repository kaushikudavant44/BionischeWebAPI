package com.bionische.biotech.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.insurance.model.InsuranceUserProfile;
import com.bionische.biotech.model.PatientDetails;


public interface PatientInsuranceRepository extends JpaRepository<InsuranceUserProfile, Integer>{
	
	
	InsuranceUserProfile save(InsuranceUserProfile patientProfile);

	
	
	
	
	
	
	
	
	
}
