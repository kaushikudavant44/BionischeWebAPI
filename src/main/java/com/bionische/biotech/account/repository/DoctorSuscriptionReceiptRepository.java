package com.bionische.biotech.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.account.model.DoctorSuscriptionReceipt;

public interface DoctorSuscriptionReceiptRepository extends JpaRepository<DoctorSuscriptionReceipt, Integer>{

	
	@Query(value="select  s.suscription_id, s.doctor_id, s.amount, s.order_id, s.created_date, c.gst_no as company_gst_no, "
			+ " s.txn_id, s.package_amt, d.gst_no, c.contact_no1, c.contact_no2, c.email, c.website, c.address, "
			+ "c.Company_name from m_bionische_company_info c, t_doctor_subscription_details s, doctor_bank_info d where d.doctor_id=s.doctor_id AND  s.doctor_id=:doctorId AND s.txn_status=1 ORDER BY s.suscription_id desc",nativeQuery=true)
	List<DoctorSuscriptionReceipt> getDoctorSuscriptionReceipt(@Param("doctorId")int doctorId);
	
}
