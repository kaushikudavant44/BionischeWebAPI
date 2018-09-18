package com.bionische.biotech.patientpasthistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.patientpasthistory.model.MenstrualObstetricHistory;
import com.bionische.biotech.patientpasthistory.model.PatientPersonalHistory;

public interface MenstrualObstetricHistoryRepository extends JpaRepository<MenstrualObstetricHistory, Integer>  {

	MenstrualObstetricHistory  save(MenstrualObstetricHistory menstrualObstetricHistory);
	MenstrualObstetricHistory  findBypatientId(MenstrualObstetricHistory menstrualObstetricHistory);
	
	MenstrualObstetricHistory findByPatientId(int patientId);
	
}
