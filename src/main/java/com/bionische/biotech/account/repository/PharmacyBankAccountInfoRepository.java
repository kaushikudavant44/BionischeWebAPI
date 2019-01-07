package com.bionische.biotech.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.account.model.PharmacyBankAccountInfo;

public interface PharmacyBankAccountInfoRepository extends JpaRepository<PharmacyBankAccountInfo, Integer>{

	
	PharmacyBankAccountInfo save(PharmacyBankAccountInfo pharmacyBankAccountInfo);

	PharmacyBankAccountInfo findByMedicalIdAndDelStatus(int medicalId, int delStatus); 
	
}
