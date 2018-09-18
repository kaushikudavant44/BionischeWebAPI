package com.bionische.biotech.ewallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.ewallet.model.UserWalletDetails;

public interface UserWalletDetailsRepository extends JpaRepository<UserWalletDetails, Integer>{

	
	UserWalletDetails save(UserWalletDetails userWalletDetails); 
	UserWalletDetails findByUserIdAndUserType(int userId, int userType);
	
}
