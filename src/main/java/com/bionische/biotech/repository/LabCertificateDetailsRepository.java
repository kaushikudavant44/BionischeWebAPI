package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.DoctorCertificateDetails;
import com.bionische.biotech.model.LabCertificateDetails;

public interface LabCertificateDetailsRepository extends JpaRepository<LabCertificateDetails, Integer>{
	
	LabCertificateDetails save(LabCertificateDetails labCertificateDetails);
	
	LabCertificateDetails findByLabIdAndDelStatus(int labId,int delStatus);
	

}
