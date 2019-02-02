package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.ewallet.model.TransactionWalletDetails;

public interface TransactionWalletDetailsRepository extends JpaRepository<TransactionWalletDetails, Integer>{

	
	TransactionWalletDetails save(TransactionWalletDetails transactionWalletDetails);
	
	TransactionWalletDetails findByToUserIdAndTransactionType(int userId,int transactionType);
}
