package com.bionische.biotech.paymenthistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.paymenthistory.model.GetPharmacyPaymentDetails;

public interface GetPharmacyPaymentDetailsRepository extends JpaRepository<GetPharmacyPaymentDetails, Integer>{

	
	@Query(value=" SELECT t.medical_request_id, t.meet_id, t.order_date, t.patient_id, t.medical_id, t.delivery_type, t.payment_status, t.total_amt,"
			+ "  t.txn_id, t.order_id, t.payment_date, CONCAT(p.f_name,' ',p.l_name)as patient_name, m.medical_name "
			+ " from prescription_to_medical t, medical_details m, patient_details p WHERE t.payment_date BETWEEN :fromDate AND :toDate AND t.payment_status!=0 AND t.medical_id=:medicalId AND m.medical_id=t.medical_id AND p.patient_id=t.patient_id",nativeQuery=true)
	List<GetPharmacyPaymentDetails> getPharmacyPaymentDetailsByMedicalId(@Param("fromDate")String fromDate, @Param("toDate")String toDate,  @Param("medicalId")int medicalId);

	
	
	@Query(value=" SELECT t.medical_request_id, t.meet_id, t.order_date, t.patient_id, t.medical_id, t.delivery_type, t.payment_status, t.total_amt,"
			+ "  t.txn_id, t.order_id, t.payment_date, CONCAT(p.f_name,' ',p.l_name)as patient_name, m.medical_name "
			+ " from prescription_to_medical t, medical_details m, patient_details p WHERE t.payment_date BETWEEN :fromDate AND :toDate AND t.payment_status!=0 AND t.patient_id=:patientId AND m.medical_id=t.medical_id AND p.patient_id=t.patient_id",nativeQuery=true)
	List<GetPharmacyPaymentDetails> getPharmacyPaymentDetailsByPatientId(@Param("fromDate")String fromDate, @Param("toDate")String toDate,  @Param("patientId")int patientId);
}
