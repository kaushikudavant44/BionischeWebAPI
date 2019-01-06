package com.bionische.biotech.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionische.biotech.account.model.GetLabReportPaymentForReceipt;

public interface GetLabReportPaymentForReceiptRepository extends JpaRepository<GetLabReportPaymentForReceipt, Integer>{

	@Query(value="select t.id, t.to_user_id as lab_id, t.amount, t.txn_id, t.payment_date, t.from_user_id as patient_id from  transaction t where t.payment_date between :fromDate AND :toDate AND t.to_user_id=:labId AND t.status=1 AND t.int_2=0 AND t.amount_type=2 order by t.payment_date ASC",nativeQuery=true)
	List<GetLabReportPaymentForReceipt> getLabConsultingPaymentForReceipt(int labId, String fromDate,
			String toDate);

}
