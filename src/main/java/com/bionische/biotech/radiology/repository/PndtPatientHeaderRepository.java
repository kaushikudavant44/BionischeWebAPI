package com.bionische.biotech.radiology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.radiology.model.PndtPatientHeader;

public interface PndtPatientHeaderRepository extends JpaRepository<PndtPatientHeader, Integer> {
	
	PndtPatientHeader save(PndtPatientHeader pndtPatientHeader);

	@Query(value="SELECT * FROM pndt_patient_header p WHERE p.patient_id=1 ORDER BY p.pndt_header_id DESC LIMIT 1",nativeQuery=true)
	PndtPatientHeader getPatientDetailsById(@Param("patientId") int patientId);
	
}
