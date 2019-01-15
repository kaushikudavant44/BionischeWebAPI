package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetPatientDetailsForEdit;

public interface GetPatientDetailsForEditRepository extends JpaRepository<GetPatientDetailsForEdit, Integer>{

	
	
	@Query(value="SELECT p.* , c.city_name, s.state_name, co.country_name from city c, country co, state s, patient_details p"
			+ " where p.patient_id=:patientId AND p.city_id=c.city_id AND p.country_id=co.country_id AND p.state_id=s.state_id",nativeQuery=true)
	GetPatientDetailsForEdit getPatientDetailsByPatientId(@Param("patientId") int patientId);
}
