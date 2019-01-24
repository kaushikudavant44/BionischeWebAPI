package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetLabBillDetails;

public interface GetLabBillDetailsRepository extends JpaRepository<GetLabBillDetails, Integer>{

	@Query(value="SELECT t.id, t.from_user_id, t.to_user_id, t.amount_type, t.status, t.amount, t.discount, t.total_amount, " + 
			"t.report_id, t.txn_id, t.order_id, t.payment_date, CONCAT(p.f_name,' ',p.l_name)AS patient_name, l.lab_name,r.lab_test_id,r.report_file_name,p.email,l.contact, " + 
			"l.address FROM transaction t, lab_details l, patient_details p,patient_reports r WHERE t.status!=0 AND t.to_user_id=:labId AND t.id=:id AND r.report_id=t.report_id " + 
			"AND l.lab_id=t.to_user_id AND p.patient_id=t.from_user_id",nativeQuery=true)
	GetLabBillDetails getLabBillDetailsRepository(@Param("labId")int labId,@Param("id")int id);
	
}
