package com.bionische.biotech.patientpasthistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.patientpasthistory.model.PatientPastHistoryIIlness;
 
 
 

public interface PatientPastHistoryIIlnessRepository  extends JpaRepository<PatientPastHistoryIIlness, Integer> {

	
	PatientPastHistoryIIlness  save(PatientPastHistoryIIlness patientPastHistoryIIlness);
//	PatientPastHistoryIIlness findByPatientId(int patientId);

	
	@Query(value=" SELECT * from past_history_illness where  illness_id IN(:patientHistoryList)",nativeQuery=true)

	List<PatientPastHistoryIIlness> getPastHistoryIllness(@Param("patientHistoryList")List<String> patientHistoryList);
	
	
}
