package com.bionische.biotech.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.insurance.model.InsurancePremiumDetails;

public interface InsurancePremiumDetailsRepository extends JpaRepository<InsurancePremiumDetails, Integer>{

	
	InsurancePremiumDetails save(InsurancePremiumDetails insurancePremiumDetails);

	}


