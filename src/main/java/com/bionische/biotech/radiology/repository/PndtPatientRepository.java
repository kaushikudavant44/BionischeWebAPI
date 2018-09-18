package com.bionische.biotech.radiology.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.radiology.model.PNDTPatientDetails;

public interface PndtPatientRepository extends JpaRepository<PNDTPatientDetails, Integer>{

	PNDTPatientDetails save(PNDTPatientDetails pndtPatientDetails);
	
	PNDTPatientDetails findByPndtId(int pndtId);
}
 