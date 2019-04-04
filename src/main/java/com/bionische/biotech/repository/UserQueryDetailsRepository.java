package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.UserQueryDetails;

public interface UserQueryDetailsRepository extends JpaRepository<UserQueryDetails, Integer>{

	
	UserQueryDetails save(UserQueryDetails userQueryDetails);
}
