package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.ewallet.model.WalletDetails;

public interface WalletDetailsRepository extends JpaRepository<WalletDetails, Integer>{

	WalletDetails save(WalletDetails walletDetails);
	
}
