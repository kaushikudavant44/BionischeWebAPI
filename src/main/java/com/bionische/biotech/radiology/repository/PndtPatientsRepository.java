package com.bionische.biotech.radiology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.radiology.model.PndtPatients;

public interface PndtPatientsRepository extends JpaRepository<PndtPatients, Integer>{

	@Query(value="SELECT pndt_id, pndt_patient_id, patient_name ,name_of_doctor,created_date,status,state " + 
			"FROM pndt_patient_details " + 
			"WHERE lab_id=:labId AND pndt_id IN ( " + 
			"    SELECT MAX(pndt_id) " + 
			"    FROM pndt_patient_details " + 
			"    GROUP BY pndt_patient_id " + 
			");" ,nativeQuery=true)
	List<PndtPatients> findByLabId(@Param("labId") int labId);
	
}
