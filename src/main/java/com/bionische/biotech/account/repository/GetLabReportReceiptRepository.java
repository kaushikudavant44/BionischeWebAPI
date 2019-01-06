package com.bionische.biotech.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.account.model.GetLabReportReceipt;

public interface GetLabReportReceiptRepository extends JpaRepository<GetLabReportReceipt, Integer>{

	@Query(value="SELECT r.receipt_no, r.lab_id AS lab_id, r.created_date, r.tot_amount, r.txn_id,"
			+ " r.date, r.from_date, r.to_date, r.paid_amt, r.commission_amt, c.gst_no AS company_gst_no,"
			+ " db.gst_no, c.contact_no1, c.contact_no2 ,c.email, c.website, c.address, c.company_name,"
			+ "  l.lab_name FROM lab_details l, m_bionische_company_info c,t_lab_report_receipt r,"
			+ " lab_bank_info db WHERE r.from_date BETWEEN :fromDate AND :toDate AND r.lab_id=:labId AND"
			+ " r.lab_id=l.lab_id AND r.lab_id=db.lab_id",nativeQuery=true)
List<GetLabReportReceipt> getLabReportReceipt(@Param("fromDate")String fromDate, @Param("toDate")String toDate, @Param("labId")int labId);

}
