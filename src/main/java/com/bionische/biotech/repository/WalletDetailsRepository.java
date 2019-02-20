package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.ewallet.model.WalletDetails;

public interface WalletDetailsRepository extends JpaRepository<WalletDetails, Integer>{

	WalletDetails save(WalletDetails walletDetails);
	
	WalletDetails findByUserIdAndUserType(int userId, int userType);
	
	WalletDetails findByWalletId(int walletId);
	
	@Transactional
	@Modifying
	@Query("UPDATE WalletDetails a SET a.walletAmount =:walletAmount  WHERE a.walletId=:walletId")
	int updateWalletAmount(@Param("walletId")int walletId,@Param("walletAmount")float walletAmount);
	
	
}
