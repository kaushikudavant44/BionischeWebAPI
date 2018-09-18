package com.bionische.biotech.patientpasthistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.patientpasthistory.model.PatientFamilyHistory;
import com.bionische.biotech.patientpasthistory.model.PatientPersonalHistory;

public interface PatientFamilyHistoryRepository extends JpaRepository<PatientFamilyHistory, Integer>  {

	PatientFamilyHistory  save(PatientFamilyHistory patientFamilyHistory);
	PatientFamilyHistory findByPatientId(int patientId);
}
