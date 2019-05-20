package com.bionische.biotech.patientpasthistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.patientpasthistory.model.PatientPastHistoryIIlness;
 
 
 

public interface PatientPastHistoryIIlnessRepository  extends JpaRepository<PatientPastHistoryIIlness, Integer> {

	
	PatientPastHistoryIIlness  save(PatientPastHistoryIIlness patientPastHistoryIIlness);
//	PatientPastHistoryIIlness findByPatientId(int patientId);

	List<PatientPastHistoryIIlness> findAll();
	
	@Query(value=" SELECT * from past_history_illness where  illness_id IN(:patientHistoryList)",nativeQuery=true)

	List<PatientPastHistoryIIlness> getPastHistoryIllness(@Param("patientHistoryList")List<String> patientHistoryList);
	
	
	@Query(value="SELECT i.illness_desc, i.int_2, i.string1,i.string2, i.illness_name, i.illness_id, CASE WHEN FIND_IN_SET(i.illness_id, p.past_history_illness_id) THEN 1 ELSE 0 END AS int_1 FROM past_history_illness i, patient_past_history p WHERE p.patient_id=:patientId ",nativeQuery=true)

	List<PatientPastHistoryIIlness> getPastHistory(@Param("patientId")int patientId);
}
