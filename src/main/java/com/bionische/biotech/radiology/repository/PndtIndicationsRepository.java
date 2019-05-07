package com.bionische.biotech.radiology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.radiology.model.PndtIndications;

public interface PndtIndicationsRepository extends JpaRepository<PndtIndications, Integer>{

	List<PndtIndications> findAll();
	
}
