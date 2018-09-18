package com.bionische.biotech.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.insurance.model.ProposerDetails;

public interface ProposerDetailsRepository extends JpaRepository<ProposerDetails, Integer>{
	
	
	ProposerDetails save(ProposerDetails proposerDetails);

}
