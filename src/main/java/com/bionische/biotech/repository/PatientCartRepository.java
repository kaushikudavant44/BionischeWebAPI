package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.LabDetails;
import com.bionische.biotech.model.PatientCart;


public interface PatientCartRepository extends JpaRepository<PatientCart, Integer>{

	PatientCart save(PatientCart patientCart);
	
	@Query(value=" SELECT * from patient_cart where patient_id=:patientId",nativeQuery=true)
	List<PatientCart> getAllCartProductsByPatientId(@Param("patientId")int patientId);
	
	@Query(value=" SELECT count(cart_id) from patient_cart where patient_id=:patientId",nativeQuery=true)
	int getPatientCartCount(@Param("patientId")int patientId);

}
