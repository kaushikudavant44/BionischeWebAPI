package com.bionische.biotech.paymenthistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.paymenthistory.model.GetLabPaymentDetails;

public interface GetLabPaymentDetailsRepository extends JpaRepository<GetLabPaymentDetails, Integer>{

	@Query(value=" SELECT t.id, t.from_user_id, t.to_user_id, t.amount_type, t.status, t.amount, t.discount, t.total_amount,"
			+ " t.report_id, t.txn_id, t.order_id, t.payment_date, CONCAT(p.f_name,' ',p.l_name)as patient_name, l.lab_name "
			+ " from transaction t, lab_details l, patient_details p WHERE t.payment_date BETWEEN :fromDate AND :toDate AND t.status!=0 AND t.to_user_id=:labId AND l.lab_id=t.to_user_id AND p.patient_id=t.from_user_id",nativeQuery=true)
	List<GetLabPaymentDetails> getLabPaymentByLabId(@Param("fromDate")String fromDate, @Param("toDate")String toDate, 
			@Param("labId")int labId);
	
	@Query(value=" SELECT t.id, t.from_user_id, t.to_user_id, t.amount_type, t.status, t.amount, t.discount, t.total_amount,"
			+ " t.report_id, t.txn_id, t.order_id, t.payment_date, CONCAT(p.f_name,' ',p.l_name)as patient_name, l.lab_name "
			+ " from transaction t, lab_details l, patient_details p WHERE t.payment_date BETWEEN :fromDate AND :toDate AND t.status!=0 AND t.from_user_id=:patientId AND l.lab_id=t.to_user_id AND p.patient_id=t.from_user_id",nativeQuery=true)
	List<GetLabPaymentDetails> getLabPaymentByPatientId(@Param("fromDate")String fromDate, @Param("toDate")String toDate,  @Param("patientId")int patientId);
}
