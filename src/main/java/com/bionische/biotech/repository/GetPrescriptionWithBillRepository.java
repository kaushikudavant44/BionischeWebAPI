package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetPrescriptionWithBill;


public interface GetPrescriptionWithBillRepository  extends JpaRepository<GetPrescriptionWithBill, Integer>{
	
	@Query(value=" SELECT p.medicine_name,p.medicine_quantity,b.prescription_bill_id,b.medical_request_id,b.price,b.medicine_id,b.meet_id,b.int_1,b.int_2,b.del_status,b.medical_id,b.bill_date,m.status AS payment_status,m.int_1 AS deliver_status,(SELECT SUM(price) FROM priscription_bill WHERE medical_request_id=:medicalReqId) AS total_bill FROM priscription_bill b,"
			+ " prescription_details p,prescription_to_medical m WHERE b.medical_request_id=:medicalReqId AND b.medicine_id=p.prescription_id AND m.medical_request_id=b.medical_request_id;",nativeQuery=true)

	List<GetPrescriptionWithBill> getCompletedPrescriptionAndBill(@Param("medicalReqId")int medicalReqId);

}
