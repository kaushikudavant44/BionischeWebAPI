package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.PackageDetails;

public interface PackageDetailsRepository extends JpaRepository<PackageDetails, Integer>{

	PackageDetails save(PackageDetails packageDetails);
	
	List<PackageDetails> findByUserTypeAndDelStatus(int userType,int delStatus);

	 
	
	@Transactional
	@Modifying
	@Query("UPDATE PackageDetails set delStatus=1 where packageId=:packageId")
	int deletePackage(@Param("packageId")int packageId); 
}
