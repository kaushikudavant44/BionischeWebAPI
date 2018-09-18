package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.SubmitPrescBill;

public interface SubmitPrescBillRepository extends JpaRepository<SubmitPrescBill, Integer>{
	
	SubmitPrescBill save(SubmitPrescBill submitPrescBill);
	
	

}

