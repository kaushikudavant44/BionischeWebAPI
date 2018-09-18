package com.bionische.biotech.patientpasthistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.patientpasthistory.model.MenstrualObstetricHistory;
import com.bionische.biotech.patientpasthistory.model.PatientPersonalHistory;
import com.bionische.biotech.stemcell.model.StemCellBankRatingDetails;

public interface PatientPersonalHistoryRepository extends JpaRepository<PatientPersonalHistory, Integer>  {

	PatientPersonalHistory  save(PatientPersonalHistory patientPersonalHistory);
	
 
 	
	PatientPersonalHistory findByPatientId(int patientId);
}
