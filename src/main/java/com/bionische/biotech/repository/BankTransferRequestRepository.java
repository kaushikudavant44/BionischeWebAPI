package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.ewallet.model.BankTransferRequest;

public interface BankTransferRequestRepository extends JpaRepository<BankTransferRequest, Integer>{

	BankTransferRequest save(BankTransferRequest bankTransferRequest);
	
}
