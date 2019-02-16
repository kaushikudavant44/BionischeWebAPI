package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.SuggestLabTestFromDoctor;

public interface SuggestLabTestFromDoctorRepository extends JpaRepository<SuggestLabTestFromDoctor, Integer>{

	
	SuggestLabTestFromDoctor save(SuggestLabTestFromDoctor suggestLabTestFromDoctor);
	
	
}
