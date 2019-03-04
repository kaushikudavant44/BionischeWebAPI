package com.bionische.biotech.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.account.model.LabReportReceipt;

public interface LabReportReceiptRepository extends JpaRepository<LabReportReceipt, String>{

	
	LabReportReceipt save(LabReportReceipt labReportReceipt);
	
	@Query(value="SELECT COALESCE((SELECT  r.date  FROM t_lab_report_receipt r WHERE r.lab_id=:labId  ORDER BY r.receipt_no DESC LIMIT 1),"
			+ " (SELECT a.payment_date  FROM t_lab_appointment_details a  WHERE   a.lab_id=:labId  AND a.payment_status=1 AND a.payment_clear_receipt_no=0"
			+ " ORDER BY a.payment_date ASC LIMIT 1))AS date",nativeQuery=true)
	String getLastDateOfReportByLabId(@Param("labId")int labId);
	
}
