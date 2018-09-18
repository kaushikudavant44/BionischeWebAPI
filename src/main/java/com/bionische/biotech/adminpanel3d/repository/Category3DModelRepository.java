package com.bionische.biotech.adminpanel3d.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.adminpanel3d.model.Category3DModel;

public interface Category3DModelRepository extends JpaRepository<Category3DModel, Integer>{

	
	Category3DModel save(Category3DModel category3DModel);
	List<Category3DModel> findAll();
	
}
