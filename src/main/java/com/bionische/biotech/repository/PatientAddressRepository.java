package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.PatientAddress;

public interface PatientAddressRepository extends JpaRepository<PatientAddress, Long>{
	
	@Query(value="SELECT p.patient_id,c.city_name,s.state_name,t.country_name,p.address,p.contact,p.int_2 FROM patient_details p,city c,state s,"
			+ "country t WHERE p.patient_id=:patientId AND p.del_status=0 AND p.city_id=c.city_id AND p.state_id=s.state_id AND p.country_id=t.country_id",nativeQuery=true)
	PatientAddress getPatientAddress(@Param("patientId") int patientId);
	

}
