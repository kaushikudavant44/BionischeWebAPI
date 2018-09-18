package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.AdminDetails;

public interface AdminDetailsRepository extends JpaRepository<AdminDetails, Integer>{
	
	AdminDetails findByEmail(String email);

}
