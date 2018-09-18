package com.bionische.biotech.adminpanel3d.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.adminpanel3d.model.SubModelsDetails;

public interface SubModelsDetailsRepository extends JpaRepository<SubModelsDetails, Integer>{

	
	SubModelsDetails save(SubModelsDetails subModelsDetails);
	List<SubModelsDetails> findBySubModelId(int subModelId);
	
}
