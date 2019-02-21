package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetLabBillDetails;

public interface GetLabBillDetailsRepository extends JpaRepository<GetLabBillDetails, Integer>{

	@Query(value="SELECT a.lab_app_id, a.patient_id, a.lab_id, a.amount_type, a.payment_status, a.amount, a.discount, a.paid_amount, " + 
			" a.txn_id, a.order_id, a.payment_date, CONCAT(p.f_name,' ',p.l_name)AS patient_name, l.lab_name, a.test_id_list,GROUP_CONCAT( t.lab_test_name SEPARATOR ', ')AS lab_test_name, p.email,l.contact, " + 
			"l.address FROM t_lab_appointment_details a, lab_tests t, lab_details l, patient_details p WHERE a.payment_status!=0 AND a.lab_app_id=:id  " + 
			"AND l.lab_id=a.lab_id AND p.patient_id=a.patient_id",nativeQuery=true)
	GetLabBillDetails getLabBillDetailsRepository(@Param("id")int id);
	
}
