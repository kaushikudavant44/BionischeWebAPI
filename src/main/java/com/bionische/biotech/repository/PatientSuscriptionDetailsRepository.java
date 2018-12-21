package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.PatientSuscriptionDetails;

public interface PatientSuscriptionDetailsRepository extends JpaRepository<PatientSuscriptionDetails, Integer>{

	
	PatientSuscriptionDetails save(PatientSuscriptionDetails patientSuscriptionDetails);
	
	PatientSuscriptionDetails findByPatientIdAndStatus(int patientId, int status);

	PatientSuscriptionDetails findByStatusNotAndPatientId(int status, int patientId);
}
