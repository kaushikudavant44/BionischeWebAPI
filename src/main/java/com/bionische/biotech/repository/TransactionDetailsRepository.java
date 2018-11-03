package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.TransactionDetails;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Integer>{

	TransactionDetails save(TransactionDetails transactionDetails);
	
}
