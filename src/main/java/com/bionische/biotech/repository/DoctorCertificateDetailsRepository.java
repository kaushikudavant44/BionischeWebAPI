package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.DoctorCertificateDetails;

public interface DoctorCertificateDetailsRepository extends JpaRepository<DoctorCertificateDetails, Integer>{

	
	DoctorCertificateDetails save(DoctorCertificateDetails doctorCertificateDetails);
	
	DoctorCertificateDetails findByDoctorIdAndDelStatus(int doctorId, int delStatus);
}
