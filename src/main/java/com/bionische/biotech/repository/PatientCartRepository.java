package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.PatientCart;


public interface PatientCartRepository extends JpaRepository<PatientCart, Integer>{

	PatientCart save(PatientCart patientCart);
	
	@Query(value=" SELECT * from patient_cart where patient_id=:patientId",nativeQuery=true)
	List<PatientCart> getAllCartProductsByPatientId(@Param("patientId")int patientId);
	
	@Query(value=" SELECT count(cart_id) from patient_cart where patient_id=:patientId",nativeQuery=true)
	int getPatientCartCount(@Param("patientId")int patientId);
	
	@Query(value=" SELECT * from patient_cart where patient_id=:patientId AND meet_id=:meetId",nativeQuery=true)
	PatientCart getCartProductByMeetId(@Param("patientId")int patientId,@Param("meetId")int meetId);
	
	@Transactional
	@Modifying
	@Query("DELETE from PatientCart WHERE cartId=:cartId")
	int deleteCartItem(@Param("cartId")int cartId);

}
