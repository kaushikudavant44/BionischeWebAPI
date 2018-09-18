package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.FamilyDetails;

public interface FamilyDetailsRepository extends JpaRepository<FamilyDetails, Integer>{

	
	FamilyDetails save(FamilyDetails familyDetails);
}
