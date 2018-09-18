package com.bionische.biotech.ewallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.ewallet.model.UserWalletTransaction;

public interface UserWalletTransactionRepository extends JpaRepository<UserWalletTransaction, Integer>{

	UserWalletTransaction save(UserWalletTransaction userWalletTransaction);
	
	List<UserWalletTransaction> findFirst10ByUserIdAndUserTypeOrderByTransactionIdDesc(int userId, int userType);
	
	List<UserWalletTransaction> findByUserIdAndUserTypeOrderByTransactionIdDesc(int userId, int userType);
}
