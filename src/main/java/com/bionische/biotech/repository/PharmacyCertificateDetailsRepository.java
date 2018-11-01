package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.PharmacyCertificateDetails;

public interface PharmacyCertificateDetailsRepository extends JpaRepository<PharmacyCertificateDetails, Integer>{

	
	PharmacyCertificateDetails save(PharmacyCertificateDetails pharmacyCertificateDetails);
	
	PharmacyCertificateDetails findByPharmacyIdAndDelStatus(int doctorId, int delStatus);
}
