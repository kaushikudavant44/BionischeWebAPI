package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.PatientCallDetails;

public interface PatientCallDetailsRepository extends JpaRepository<PatientCallDetails, Integer>{

	
	PatientCallDetails save(PatientCallDetails patientCallDetails);
	
	@Query(value=" SELECT c.id, c.patient_id, c.doctor_id, c.datetime, c.status, CONCAT(d.f_name, ' ', d.l_name) AS from_name"
			+ " from patient_call_details c, doctor_details d WHERE c.patient_id=:patientId AND c.status=:status AND c.doctor_id=d.doctor_id",nativeQuery=true)
	List<PatientCallDetails> getByPatientIdAndStatus(@Param("patientId")int patientId,@Param("status")int status);
	
	@Transactional
	@Modifying
	@Query("update from PatientCallDetails set status=:status WHERE id=:id")
	int updateStatus(@Param("id")int id,@Param("status")int status);
	
	@Transactional
	@Modifying
	@Query("update from PatientCallDetails set status=:status WHERE patientId=:patientId")
	int updateStatusByPatientId(@Param("patientId")int patientId,@Param("status")int status);
}
