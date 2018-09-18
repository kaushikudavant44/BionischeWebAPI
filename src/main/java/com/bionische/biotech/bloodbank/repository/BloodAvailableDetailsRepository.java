package com.bionische.biotech.bloodbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.bloodbank.model.BloodAvailableDetails;
 

public interface BloodAvailableDetailsRepository extends JpaRepository<BloodAvailableDetails, Integer>{
	BloodAvailableDetails save(BloodAvailableDetails bloodAvailableDetails);
}
                                           