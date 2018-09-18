package com.bionische.biotech.stemcell.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.stemcell.model.PatientEnrollDetails;

 

public interface PatientEnrollDetailsRepository extends JpaRepository<PatientEnrollDetails, Integer>{

	PatientEnrollDetails save(PatientEnrollDetails patientEnrollDetails);

	
	
	     
	
}
        