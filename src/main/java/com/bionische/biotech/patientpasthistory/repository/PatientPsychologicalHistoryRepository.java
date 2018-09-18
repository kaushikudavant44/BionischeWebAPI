package com.bionische.biotech.patientpasthistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.patientpasthistory.model.PatientPersonalHistory;
import com.bionische.biotech.patientpasthistory.model.PatientPsychologicalHistory;

public interface PatientPsychologicalHistoryRepository extends JpaRepository<PatientPsychologicalHistory, Integer>  {

	
	PatientPsychologicalHistory  save(PatientPsychologicalHistory patientPsychologicalHistory);
	PatientPsychologicalHistory findByPatientId(int patientId);
}
