package com.bionische.biotech.patientpasthistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.history.model.PatientSystemDetails;
import com.bionische.biotech.insurance.model.GetBoughtInsuranceDetails;
import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.model.LabTests;
import com.bionische.biotech.patientpasthistory.model.PatientPastHistory;
import com.bionische.biotech.patientpasthistory.model.PatientPersonalHistory;

public interface PatientPastHistoryRepository extends JpaRepository<PatientPastHistory, Integer>  {

	
	PatientPastHistory  save(PatientPastHistory patientPastHistory);
	
	
	
	PatientPastHistory findByPatientId(int patientId);
	
	
	@Query(value=" SELECT p.past_history_id, p.patient_id, p.past_history_illness_id ,p.other, l.illness_id, l.illness_name, l.illness_desc, l.int_1, l.int_2, l.string1, l.string2, p.int_1, p.int_2, p.string1, p.string2  from patient_past_history p,past_history_illness l where  p.patient_id=:patientId",nativeQuery=true)
	
	PatientPastHistory getPastHistoryIllness(@Param("patientId")int patientId);
   
	

	/*@Query(value=" SELECT * from patient_past_history where past_history_illness_id IN(:patientHistoryList) AND  patient_id=:patientId",nativeQuery=true)
	PatientPastHistory getPastHistoryIllness(@Param("patientHistoryList")List<String> patientHistoryList ,@Param("patientId")int patientId);
	*/
	
}
