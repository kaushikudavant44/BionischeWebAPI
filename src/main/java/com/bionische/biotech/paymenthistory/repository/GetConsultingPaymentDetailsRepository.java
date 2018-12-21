package com.bionische.biotech.paymenthistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.paymenthistory.model.GetConsultingPaymentDetails;

public interface GetConsultingPaymentDetailsRepository extends JpaRepository<GetConsultingPaymentDetails, Integer>{

	@Query(value=" SELECT a.appoint_id, a.doctor_id, a.patient_id, a.payment_status, a.txn_id, a.order_id, a.amount, a.payment_date,"
			+ "CONCAT(d.f_name,' ', d.l_name)as doctor_name, CONCAT(p.f_name,' ',p.l_name)as patient_name from doctor_appointment a, doctor_details d, patient_details p where a.patient_id=p.patient_id AND a.doctor_id=:doctorId AND d.doctor_id=a.doctor_id AND a.payment_date BETWEEN :fromDate AND :toDate AND a.payment_status!=0",nativeQuery=true)
	List<GetConsultingPaymentDetails> getConsultingPaymentDetailsByDoctorId(@Param("doctorId")int doctorId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);


	@Query(value=" SELECT a.appoint_id, a.doctor_id, a.patient_id, a.payment_status, a.txn_id, a.order_id, a.amount, a.payment_date,"
			+ "CONCAT(d.f_name,' ', d.l_name)as doctor_name, CONCAT(p.f_name,' ',p.l_name)as patient_name from doctor_appointment a, doctor_details d, patient_details p where a.patient_id=p.patient_id AND a.doctor_id=:doctorId AND d.doctor_id=a.doctor_id AND a.payment_date BETWEEN :fromDate AND :toDate AND a.payment_status!=0",nativeQuery=true)
	List<GetConsultingPaymentDetails> getConsultingPaymentDetailsByPatientId(@Param("doctorId")int doctorId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);

}
