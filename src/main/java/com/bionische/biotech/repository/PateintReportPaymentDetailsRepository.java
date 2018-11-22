package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.PateintReportPaymentDetails;

public interface PateintReportPaymentDetailsRepository extends JpaRepository<PateintReportPaymentDetails, Integer>{

	@Query(value="SELECT r.report_id,r.report_date,l.lab_name,r.report_file_name,r.int_2 AS payment_status,lt.lab_test_name,r.lab_test_id,t.created_date,t.amount_type,t.amount,t.discount,\r\n" + 
			"t.total_amount FROM patient_reports r, transaction t,lab_details l, lab_tests lt WHERE r.report_id=t.report_id AND  r.lab_test_id=lt.lab_test_id AND  r.lab_id=l.lab_id \r\n" + 
			"AND r.patient_id=:patientId AND r.int_2=:paymentStatus",nativeQuery=true)
	List<PateintReportPaymentDetails> findByPatientIdAndPaymentStatus(@Param("patientId")int patientId,@Param("paymentStatus")int paymentStatus);
	
}
