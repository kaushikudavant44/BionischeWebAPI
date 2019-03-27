package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.SavePatientVaccination;

public interface SavePatientVaccinationRepository extends JpaRepository<SavePatientVaccination, Integer>{

	SavePatientVaccination save(SavePatientVaccination savePatientVaccination);
	
	
	@Query(value=" SELECT CONCAT(d.f_name,\" \",d.l_name) AS string_1,v.vaccination_id,v.patient_id,v.id, v.status " + 
			",v.doctor_id,v.int_1,v.int_2,v.created_date,v.modified_date " + 
			" FROM vaccination_completed v, doctor_details d WHERE v.doctor_id=d.doctor_id  AND v.patient_id=:patientId GROUP BY v.id",nativeQuery=true)
	List<SavePatientVaccination> findByPatientId(@Param("patientId")int patientId);
	
}
