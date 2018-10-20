package com.bionische.biotech.patientpasthistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.patientpasthistory.model.MenstrualObstetricHistory;
import com.bionische.biotech.patientpasthistory.model.PatientPersonalHistory;
import com.bionische.biotech.stemcell.model.StemCellBankRatingDetails;

public interface PatientPersonalHistoryRepository extends JpaRepository<PatientPersonalHistory, Integer>  {

	PatientPersonalHistory  save(PatientPersonalHistory patientPersonalHistory);
	
 
 	
	PatientPersonalHistory findByPatientId(int patientId);
	
	/*@Transactional
	@Modifying
	@Query("UPDATE patient_personal_history p SET p.marital_status =:maritalStatus,p.occupation =:occupation,p.income =:anualIncome,p.addiction =:addiction,p.dietary_habits =:dietaryHabits,p.history_of_conterception =:historyOfConterception,p.high_risk_pehaviour =:highRiskBehaviour, WHERE p.patient_id=:patientId")
	int updatepatientId(@Param("patientId") int patientId);*/
	
	
//	@Transactional
//	@Modifying
//	PatientPersonalHistory updateAll(@Param("patientId") int patientId);
	
	
	
}
