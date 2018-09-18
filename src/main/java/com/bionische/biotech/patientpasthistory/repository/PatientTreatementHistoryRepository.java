package com.bionische.biotech.patientpasthistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.patientpasthistory.model.PatientPersonalHistory;
import com.bionische.biotech.patientpasthistory.model.PatientTreatementHistory;

public interface PatientTreatementHistoryRepository extends JpaRepository <PatientTreatementHistory, Integer>  {

	PatientTreatementHistory  save(PatientTreatementHistory patientTreatementHistory);
	PatientTreatementHistory findByPatientId(int patientId);
	
		
	
}
