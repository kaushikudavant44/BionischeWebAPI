package com.bionische.biotech.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.account.model.GetPharmacyPrescriptionReceipt;

public interface GetPharmacyPrescriptionReceiptRepository extends JpaRepository<GetPharmacyPrescriptionReceipt, Integer>{

	@Query(value="SELECT r.receipt_no, r.medical_id, r.created_date, r.tot_amount, r.txn_id, r.date, r.from_date, r.to_date, r.paid_amt,"
			+ " r.commission_amt, c.gst_no as company_gst_no, db.gst_no, c.contact_no1, c.contact_no2 ,c.email, c.website, c.address, c.company_name"
			+ ", d.medical_name from medical_details d, m_bionische_company_info c, t_pharmacy_prescription_receipt r, pharmacy_bank_info db WHERE "
			+ " r.from_date BETWEEN :fromDate AND :toDate AND r.medical_id=:medicalId AND r.medical_id=d.medical_id AND r.medical_id=db.medical_id",nativeQuery=true)
	List<GetPharmacyPrescriptionReceipt> getPharmacyPrescriptionReceipt(@Param("fromDate")String fromDate, @Param("toDate")String toDate, @Param("medicalId")int medicalId);

	@Query(value="SELECT r.receipt_no, r.medical_id, r.created_date, r.tot_amount, r.txn_id, r.date, r.from_date, r.to_date, r.paid_amt,"
			+ " r.commission_amt, c.gst_no as company_gst_no, db.gst_no, c.contact_no1, c.contact_no2 ,c.email, c.website, c.address, c.company_name"
			+ ", d.medical_name from medical_details d, m_bionische_company_info c, t_pharmacy_prescription_receipt r, pharmacy_bank_info db WHERE r.receipt_no=:receiptNo",nativeQuery=true)
	GetPharmacyPrescriptionReceipt getPharmacyPrescriptionPaymentForReceipt(@Param("receiptNo")int receiptNo);

	
}
