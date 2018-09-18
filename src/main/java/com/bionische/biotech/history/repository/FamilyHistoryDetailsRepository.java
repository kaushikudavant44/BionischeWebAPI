package com.bionische.biotech.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.history.model.FamilyHistoryDetails;

public interface FamilyHistoryDetailsRepository extends JpaRepository<FamilyHistoryDetails, Integer>{

	FamilyHistoryDetails save(FamilyHistoryDetails familyHistoryDetails);

	FamilyHistoryDetails findByPatientId(int patientId);

	

	

	
	
	
}