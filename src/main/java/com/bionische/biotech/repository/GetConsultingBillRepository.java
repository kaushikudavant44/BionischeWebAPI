package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetCartProducts;
import com.bionische.biotech.model.GetConsultingBill;

public interface GetConsultingBillRepository extends JpaRepository<GetConsultingBill, Integer>{

	
	
	

	@Query(value="SELECT m.meet_id, m.int_1 AS hospital_id, m.int_2 AS appointment_id, m.date, m.patient_id, m.doctor_id, " + 
			"CONCAT(d.f_name,' ',d.l_name)AS doctor_name, CONCAT(p.f_name,' ',p.l_name)AS patient_name, d.qualification, d.signature, h.hospital_name, h.address, h.contact_no, h.email_id," + 
			"a.amount, p.email FROM doctor_details d, patient_details p, doctor_patient_meeting m, doctor_appointment a, hospital_details h WHERE " + 
			"m.meet_id=:meetId AND m.int_2=a.appoint_id AND m.int_1=h.hospital_id AND m.patient_id=p.patient_id AND m.doctor_id=d.doctor_id",nativeQuery=true)
	GetConsultingBill getConsultingBillByMeetId(@Param("meetId")int meetId);
	
}
