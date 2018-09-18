package com.bionische.biotech.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.bloodbank.model.DonorDetails;

public interface DonorDetailsRepository extends JpaRepository<DonorDetails, Integer>{
	
	
	DonorDetails save(DonorDetails donorDetails);


}
   