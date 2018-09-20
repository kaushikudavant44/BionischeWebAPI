package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.VaccinationPatientDetails;

public interface VaccinationPatientDetailsRepository extends JpaRepository<VaccinationPatientDetails, Integer>{

	@Query(value="SELECT p.patient_id,p.f_name,p.m_name,p.l_name,p.gender,p.address,p.blood_group, p.birth_date,p.del_status FROM patient_details p WHERE p.patient_id=1 AND p.del_status=0",nativeQuery=true)
	VaccinationPatientDetails getPatientByPatientId(@Param("patientId")int patientId);
	
}
