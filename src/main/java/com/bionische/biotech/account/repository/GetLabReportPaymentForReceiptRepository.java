package com.bionische.biotech.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.account.model.GetLabReportPaymentForReceipt;

public interface GetLabReportPaymentForReceiptRepository extends JpaRepository<GetLabReportPaymentForReceipt, Integer>{

	@Query(value="select t.lab_app_id, t.lab_id, t.paid_amount, t.txn_id, t.payment_date, t.patient_id"
			+ " from  t_lab_appointment_details t where t.payment_date between :fromDate AND :toDate AND t.lab_id=:labId AND t.payment_status=1 AND t.payment_clear_receipt_no=0 AND t.amount_type=2 order by t.payment_date ASC",nativeQuery=true)
	List<GetLabReportPaymentForReceipt> getLabConsultingPaymentForReceipt(@Param("labId")int labId, @Param("fromDate")String fromDate,
			@Param("toDate")String toDate);

}
