package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.SavePatientVaccination;

public interface SavePatientVaccinationRepository extends JpaRepository<SavePatientVaccination, Integer>{

	SavePatientVaccination save(SavePatientVaccination savePatientVaccination);
	
	List<SavePatientVaccination> findAll();
	
}
