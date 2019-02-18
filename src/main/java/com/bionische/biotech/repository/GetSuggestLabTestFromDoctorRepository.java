package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetSuggestLabTestFromDoctor;

public interface GetSuggestLabTestFromDoctorRepository  extends JpaRepository<GetSuggestLabTestFromDoctor, Integer>{

	@Query(value="SELECT suggest_id , s.meet_id, s.doctor_id, s.patient_id, s.test_id_list, GROUP_CONCAT( t.lab_test_name SEPARATOR ', ')AS test_name_list,"
			+ " s.lab_id,  CASE WHEN s.lab_id > 0 THEN (SELECT l.lab_name FROM lab_details l WHERE lab_id=s.lab_id) ELSE 'No lab Available' END AS lab_name"
			+ "  FROM  t_suggest_lab_test_from_doctor s, lab_tests t WHERE s.meet_id=:meetId AND FIND_IN_SET(t.lab_test_id, s.test_id_list)",nativeQuery=true)
	GetSuggestLabTestFromDoctor getSuggestLabTestFromDoctor(@Param("meetId")int meetId);
	
 
}
