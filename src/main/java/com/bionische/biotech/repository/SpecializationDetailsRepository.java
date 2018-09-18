package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.SpecializationDetails;

 

public interface SpecializationDetailsRepository extends JpaRepository<SpecializationDetails, Integer>{

	
	List<SpecializationDetails> findByDelStatus(int delStatus);
	
	SpecializationDetails findBySpecializationId(int specId);
}
