package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.VaccinationAgeDetails;

public interface VaccinationAgeDetailsRepository extends JpaRepository<VaccinationAgeDetails, Integer>{

	VaccinationAgeDetails save(VaccinationAgeDetails vaccinationAgeDetails);
	
	@Transactional
	@Modifying
	@Query("DELETE FROM VaccinationAgeDetails WHERE vaxinationAgeId=:vaxinationAgeId")
	int deleteVaccinatioAgeById(@Param("vaxinationAgeId")int vaxinationAgeId);
	
	List<VaccinationAgeDetails> findAll();
}
