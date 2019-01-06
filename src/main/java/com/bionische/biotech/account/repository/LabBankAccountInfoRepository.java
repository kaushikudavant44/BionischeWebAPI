package com.bionische.biotech.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.account.model.LabBankAccountInfo;

public interface LabBankAccountInfoRepository extends JpaRepository<LabBankAccountInfo, Integer>{

	
	LabBankAccountInfo save(LabBankAccountInfo labBankAccountInfo);
	LabBankAccountInfo findByLabIdAndDelStatus(int labId, int delStatus); 
}
