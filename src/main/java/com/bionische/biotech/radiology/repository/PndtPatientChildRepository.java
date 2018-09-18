package com.bionische.biotech.radiology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.radiology.model.ChildsModel;

public interface PndtPatientChildRepository extends JpaRepository<ChildsModel, Integer>{

	
	ChildsModel save(ChildsModel childsModel);
	
	List<ChildsModel> findByPndtId(int pndtId);
}
