package com.bionische.biotech.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.account.model.GetDoctorConsultingPaymentForReceipt;

public interface GetDoctorConsultingPaymentForReceiptRepository extends JpaRepository<GetDoctorConsultingPaymentForReceipt, Integer>{

	@Query(value="select t.appoint_id, t.doctor_id, t.amount, t.paid_by_bank_amount, t.paid_by_wallet_amount, t.is_wallet_amount, t.txn_id, t.payment_date, t.patient_id from  doctor_appointment t where t.payment_date between :fromDate AND :toDate AND t.doctor_id=:doctorId AND (t.txn_id!=0 || t.is_wallet_amount=1) AND t.payment_status=1 AND t.int_2=0 order by t.payment_date ASC",nativeQuery=true)
	List<GetDoctorConsultingPaymentForReceipt> getDoctorConsultingPaymentForReceipt(@Param("doctorId")int doctorId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);
	
	 
}
 