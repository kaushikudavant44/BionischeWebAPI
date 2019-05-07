package com.bionische.biotech.radiology.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.radiology.model.NewPndtPatientDetails;

public interface NewPndtPatientDetailsRepository extends JpaRepository<NewPndtPatientDetails, Integer>{

	NewPndtPatientDetails save(NewPndtPatientDetails newPndtPatientDetails);
}
