package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetPatientContactDetailsById;

public interface GetPatientContactDetailsByIdRepository extends JpaRepository<GetPatientContactDetailsById, Integer>{

	@Query(value="select patient_id,f_name, l_name, m_name, contact, email from patient_details where patient_id=:patientId",nativeQuery=true)
	GetPatientContactDetailsById getPatientContactDetailsById(@Param("patientId") int patient);
	
}
