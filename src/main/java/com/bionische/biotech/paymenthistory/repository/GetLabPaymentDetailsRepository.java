package com.bionische.biotech.paymenthistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.paymenthistory.model.GetLabPaymentDetails;

public interface GetLabPaymentDetailsRepository extends JpaRepository<GetLabPaymentDetails, Integer>{

	@Query(value=" SELECT t.lab_app_id, t.patient_id, t.lab_id, t.amount_type, t.payment_status, t.amount, t.discount, t.total_amount, t.paid_amount,"
			+ "  t.txn_id, t.order_id,  t.payment_date,  CONCAT(p.f_name,' ',p.l_name)AS patient_name,  l.lab_name  FROM t_lab_appointment_details t,"
			+ " lab_details l, patient_details p WHERE t.payment_date BETWEEN :fromDate AND :toDate  AND t.payment_status!=0  AND t.lab_id=:labId"
			+ "  AND l.lab_id=t.lab_id  AND p.patient_id=t.patient_id",nativeQuery=true)
	List<GetLabPaymentDetails> getLabPaymentByLabId(@Param("fromDate")String fromDate, @Param("toDate")String toDate, 
			@Param("labId")int labId);
	
	@Query(value=" SELECT t.lab_app_id, t.patient_id, t.lab_id, t.amount_type, t.payment_status, t.amount, t.discount, t.total_amount, t.paid_amount,"
			+ "  t.txn_id, t.order_id,  t.payment_date,  CONCAT(p.f_name,' ',p.l_name)AS patient_name,  l.lab_name  FROM t_lab_appointment_details t,"
			+ " lab_details l, patient_details p WHERE t.payment_date BETWEEN :fromDate AND :toDate  AND t.payment_status!=0  AND t.patient_id=:patientId"
			+ "  AND l.lab_id=t.lab_id  AND p.patient_id=t.patient_id",nativeQuery=true)
	List<GetLabPaymentDetails> getLabPaymentByPatientId(@Param("fromDate")String fromDate, @Param("toDate")String toDate,  @Param("patientId")int patientId);
}
