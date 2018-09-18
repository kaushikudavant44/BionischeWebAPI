package com.bionische.biotech.history.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.history.model.MajorDiesesDetails;
import com.bionische.biotech.history.model.PatientSystemDetails;


public interface PatientSystemDetailsRepository extends JpaRepository<PatientSystemDetails, Integer>{
	
	List<PatientSystemDetails> findByDelStatus(int delStatus);

	
	@Query(value=" SELECT * from patient_sys_details where patient_detail_id IN(:diesesIdList) AND del_status=0",nativeQuery=true)
	List<PatientSystemDetails> getDiesesDetails(@Param("diesesIdList")List<String> diesesIdList);

 
	
	
}
