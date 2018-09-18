package com.bionische.biotech.adminpanel3d.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.adminpanel3d.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer>{

	
	UserDetails findByEmailAndPassword(String email,String password);
	
}