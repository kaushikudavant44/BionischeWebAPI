package com.bionische.biotech.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.account.model.LabSuscriptionReceipt;

public interface LabSuscriptionReceiptRepository extends JpaRepository<LabSuscriptionReceipt, Integer>{

	@Query(value="select  s.suscription_id, s.lab_id, s.amount, s.order_id, s.created_date, c.gst_no as company_gst_no, d.acc_holder_name as lab_name,"
			+ " s.txn_id, s.package_amt, d.gst_no, c.contact_no1, c.contact_no2, c.email, c.website, c.address, "
			+ "c.company_name from m_bionische_company_info c, t_lab_subscription_details s, lab_bank_info d "
			+ "where d.lab_id=s.lab_id AND  s.lab_id=:labId AND s.txn_status=1 ORDER BY s.suscription_id desc",nativeQuery=true)
	List<LabSuscriptionReceipt> getLabSuscriptionReceipt(@Param("labId")int labId);

	@Query(value="select  s.suscription_id, s.lab_id, s.amount, s.order_id, s.created_date, c.gst_no as company_gst_no,d.acc_holder_name as lab_name, "
			+ " s.txn_id, s.package_amt, d.gst_no, c.contact_no1, c.contact_no2, c.email, c.website, c.address, "
			+ "c.company_name from m_bionische_company_info c, t_lab_subscription_details s, lab_bank_info d "
			+ "where  s.suscription_id=:suscriptionId",nativeQuery=true)
	LabSuscriptionReceipt getLabSuscriptionReceiptBySubscriptionId(@Param("suscriptionId")int suscriptionId);

	
	
}
