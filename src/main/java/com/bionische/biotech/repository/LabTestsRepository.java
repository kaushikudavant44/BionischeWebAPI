package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.City;
import com.bionische.biotech.model.LabTests;

public interface LabTestsRepository extends JpaRepository<LabTests, Integer>{
	
	List<LabTests> findByDelStatus(int delStatus);
	
	@Query(value=" SELECT * from lab_tests where lab_test_id=:testId AND del_status=0",nativeQuery=true)
	LabTests getTestDetailsByTestId(@Param("testId")int testId);

	@Query(value=" SELECT * from lab_tests where lab_test_id IN(:testIdList) AND del_status=0",nativeQuery=true)
	List<LabTests> getTestDetails(@Param("testIdList")List<String> testIdList);
	
	@Query(value=" SELECT * FROM lab_tests WHERE lab_test_id IN (SELECT DISTINCT lab_test_id FROM patient_reports WHERE patient_id=:patientId)",nativeQuery=true)
	List<LabTests> getTestOfPatients(@Param("patientId")int patientId);
	
	
	
}
