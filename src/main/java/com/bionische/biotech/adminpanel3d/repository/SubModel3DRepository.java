package com.bionische.biotech.adminpanel3d.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.adminpanel3d.model.SubModel3D;

public interface SubModel3DRepository extends JpaRepository<SubModel3D, Integer>{

	
	SubModel3D save(SubModel3D subModel3D);
	List<SubModel3D> findByMainModelId(int mainModelId);
	
}
