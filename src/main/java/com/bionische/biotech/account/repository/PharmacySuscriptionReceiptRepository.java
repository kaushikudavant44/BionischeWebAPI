package com.bionische.biotech.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionische.biotech.account.model.PharmacySuscriptionReceipt;

public interface PharmacySuscriptionReceiptRepository extends JpaRepository<PharmacySuscriptionReceipt, Integer>{

	@Query(value="select  s.suscription_id, s.medical_id, s.amount, s.order_id, s.created_date, c.gst_no as company_gst_no, "
			+ " s.txn_id, s.package_amt, d.gst_no, c.contact_no1, c.contact_no2, c.email, c.website, c.address, "
			+ "c.company_name from m_bionische_company_info c, t_pharmacy_subscription_details s, pharmacy_bank_info d where d.medical_id=s.medical_id AND  s.medical_id=:medicalId AND s.txn_status=1 ORDER BY s.suscription_id desc",nativeQuery=true)
	List<PharmacySuscriptionReceipt> getPharmacySuscriptionReceipt(int medicalId);

}
