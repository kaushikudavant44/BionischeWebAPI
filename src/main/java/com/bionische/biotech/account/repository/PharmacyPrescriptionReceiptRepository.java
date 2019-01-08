package com.bionische.biotech.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.account.model.PharmacyPrescriptionReceipt;

public interface PharmacyPrescriptionReceiptRepository extends JpaRepository<PharmacyPrescriptionReceipt, String>{

	PharmacyPrescriptionReceipt save(PharmacyPrescriptionReceipt pharmacyPrescriptionReceipt);

	@Query(value="SELECT COALESCE((SELECT r.date FROM t_pharmacy_prescription_receipt r WHERE r.medical_id=:medicalId ORDER BY r.receipt_no DESC LIMIT 1),(SELECT a.payment_date FROM prescription_to_medical a WHERE a.medical_id=:medicalId AND a.payment_status=1 ORDER BY a.payment_date ASC LIMIT 1))AS date",nativeQuery=true)
	String getLastDateByMedicalId(@Param("medicalId")int medicalId);
}
