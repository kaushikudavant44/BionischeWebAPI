package com.bionische.biotech.radiology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.radiology.model.PNDTPatientDetails;

public interface PndtPatientRepository extends JpaRepository<PNDTPatientDetails, Integer>{

	PNDTPatientDetails save(PNDTPatientDetails pndtPatientDetails);
	
	PNDTPatientDetails findByPndtId(int pndtId);
	
	@Query(value="SELECT * FROM pndt_patient_details p WHERE p.patient_name=:patientName ORDER BY p.pndt_id DESC LIMIT 1",nativeQuery=true)
	PNDTPatientDetails findByPndtPatientDetailsByPatientName(@Param("patientName")String patientName);
	
	
	List<PNDTPatientDetails> findPndtPatientDetailsByLabId(int labId);
}
 