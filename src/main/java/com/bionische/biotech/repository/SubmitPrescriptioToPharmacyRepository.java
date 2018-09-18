package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.SubmitPrescriptioToPharmacy;

public interface SubmitPrescriptioToPharmacyRepository extends JpaRepository<SubmitPrescriptioToPharmacy, Integer>{
	
	SubmitPrescriptioToPharmacy save(SubmitPrescriptioToPharmacy submitPrescriptioToPharmacy);
	
	@Transactional
	@Modifying
	@Query("UPDATE SubmitPrescriptioToPharmacy p SET p.int1=1  WHERE p.patientRequestToMedicalId=:patientRequestToMedicalId")
	int updateCompletedPrescription(@Param("patientRequestToMedicalId")int patientRequestToMedicalId);
	
	@Transactional
	@Modifying
	@Query("UPDATE SubmitPrescriptioToPharmacy p SET p.status=1  WHERE p.patientRequestToMedicalId=:patientRequestToMedicalId")
	int updatePaidStatus(@Param("patientRequestToMedicalId")int patientRequestToMedicalId);

	@Transactional
	@Modifying
	@Query("UPDATE SubmitPrescriptioToPharmacy p SET p.int2=1  WHERE p.patientRequestToMedicalId=:patientRequestToMedicalId")
	int updateDeliveredStatus(@Param("patientRequestToMedicalId")int patientRequestToMedicalId);

}
