package com.bionische.biotech.radiology.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.lab.RadiologistPndtDetails;

public interface RadiologistPndtDetailsRepository extends JpaRepository<RadiologistPndtDetails, Integer>{

	
	RadiologistPndtDetails save(RadiologistPndtDetails radiologistPndtDetails);
	
	RadiologistPndtDetails findByLabId(int labId);
}
