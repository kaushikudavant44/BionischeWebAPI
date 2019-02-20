package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.account.model.PatientBankAccountInfo;

public interface PatientBankAccountInfoRepository extends JpaRepository<PatientBankAccountInfo, Integer>{

	PatientBankAccountInfo save(PatientBankAccountInfo patientBankAccountInfo);
	
	PatientBankAccountInfo findByPatientIdAndDelStatus(int patientId, int delStatus);
	
}
