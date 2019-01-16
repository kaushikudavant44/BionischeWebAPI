package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetCartProducts;

public interface GetCartProductsRepository extends JpaRepository<GetCartProducts, Integer> {

	@Query(value="SELECT c.cart_id,m.meet_id,d.doctor_id,m.patient_id,CONCAT(p.f_name,' ',p.l_name) AS patient_name, h.hospital_name,\r\n" + 
			"CONCAT(d.f_name,' ',d.l_name) AS f_name,c.date_time,m.patient_problem,m.note, m.discussion FROM hospital_details h, doctor_details d,\r\n" + 
			"doctor_patient_meeting m,patient_details p,patient_cart c WHERE c.patient_id=:patientId AND c.meet_id=m.meet_id AND m.doctor_id=d.doctor_id AND h.hospital_id=m.int_1\r\n" + 
			" AND m.patient_id=p.patient_id ORDER BY c.date_time DESC",nativeQuery=true)
	List<GetCartProducts> getCartProductDetails(@Param("patientId")int patientId);
}
