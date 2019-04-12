package com.bionische.biotech.stemcell.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.SelfUploadedPrescriptionToMedical;

public interface SelfUploadedPrescriptionToMedicalRepository extends JpaRepository<SelfUploadedPrescriptionToMedical, Integer>{

	SelfUploadedPrescriptionToMedical save(SelfUploadedPrescriptionToMedical selfUploadedPrescriptionToMedical);

	@Transactional
	@Modifying
	@Query("UPDATE SelfUploadedPrescriptionToMedical p SET p.status =:status, p.totalAmt=:totAmount  WHERE p.medicalRequestId=:requestId")
	int updateMedicalOrderStatusAndAmount(@Param("requestId")int requestId, @Param("status")int status,@Param("totAmount") float totAmount);

	@Transactional
	@Modifying
	@Query("UPDATE SelfUploadedPrescriptionToMedical p SET p.paymentStatus =:paidStatus  WHERE p.medicalRequestId=:requestId")
	int updateMedicineOrderPaidStatus(@Param("requestId")int requestId, @Param("paidStatus")int paidStatus);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE SelfUploadedPrescriptionToMedical p SET p.status =:status  WHERE p.medicalRequestId=:requestId")
	int updateMedicineOrderDeliveredStatus(@Param("requestId")int requestId, @Param("status")int status);
}
