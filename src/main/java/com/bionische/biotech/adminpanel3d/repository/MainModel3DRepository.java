package com.bionische.biotech.adminpanel3d.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.adminpanel3d.model.MainModel3D;

public interface MainModel3DRepository extends JpaRepository<MainModel3D, Integer>{

	MainModel3D save(MainModel3D mainModel3D);
	List<MainModel3D> findByCatId(int catId);
}
