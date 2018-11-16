package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.PackageDetails;

public interface PackageDetailsRepository extends JpaRepository<PackageDetails, Integer>{

	PackageDetails save(PackageDetails packageDetails);
	
	List<PackageDetails> findByUserType(int userType);
}
