package com.bionische.biotech.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.account.model.BrokerageDetails;

public interface BrokerageDetailsRepository extends JpaRepository<BrokerageDetails, Integer>{

	
	BrokerageDetails save(BrokerageDetails brokerageDetails);
	
	BrokerageDetails findByDelStatus(int delStatus);
}
