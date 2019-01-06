package com.bionische.biotech.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.account.model.DoctorBankAccountInfo;

public interface DoctorBankAccountInfoRepository extends JpaRepository<DoctorBankAccountInfo, Integer>
{

	DoctorBankAccountInfo save(DoctorBankAccountInfo doctorBankAccountInfo);
	
	DoctorBankAccountInfo findByDoctorIdAndDelStatus(int doctorId, int delStatus);
	
}
