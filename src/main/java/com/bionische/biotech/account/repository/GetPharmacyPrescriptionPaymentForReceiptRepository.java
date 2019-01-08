package com.bionische.biotech.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.account.model.GetPharmacyPrescriptionPaymentForReceipt;

public interface GetPharmacyPrescriptionPaymentForReceiptRepository extends JpaRepository<GetPharmacyPrescriptionPaymentForReceipt, Integer>{

	@Query(value="select t.medical_request_id as appoint_id, t.medical_id, t.total_amt as amount, t.txn_id, t.payment_date, t.patient_id from  prescription_to_medical"
			+ " t where t.payment_date between :fromDate AND :toDate AND t.medical_id=:medicalId AND t.payment_status=1 AND"
			+ " t.int_1=0 order by t.payment_date ASC",nativeQuery=true)
	List<GetPharmacyPrescriptionPaymentForReceipt> getPharmacyPrescriptionPaymentForReceipt(@Param("medicalId")int medicalId,
			@Param("fromDate")String fromDate, @Param("toDate")String toDate);

}
