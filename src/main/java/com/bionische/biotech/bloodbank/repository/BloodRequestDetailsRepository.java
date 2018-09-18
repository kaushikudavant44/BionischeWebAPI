package com.bionische.biotech.bloodbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionische.biotech.bloodbank.model.BloodRequestDetails;

 

public interface BloodRequestDetailsRepository extends JpaRepository<BloodRequestDetails, Integer>{

	BloodRequestDetails save(BloodRequestDetails bloodRequestDetails);

	List<BloodRequestDetails> findByDelStatus(int delStatus);


	
	
	
}
             