package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.VaccinationAgeDetails;

public interface VaccinationAgeDetailsRepository extends JpaRepository<VaccinationAgeDetails, Integer>{

	
	List<VaccinationAgeDetails> findAll();
}
