package com.bionische.biotech.radiology.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.radiology.model.TestDetails;

public interface RadiologyTestDetailsRepository extends JpaRepository<TestDetails, Integer>{

	
	TestDetails save(TestDetails testDetails);
	
	List<TestDetails> findByDoctorIdAndDelStatus(int docotrId,int delStatus);
	
	@Transactional
	@Modifying
	@Query("UPDATE TestDetails s set s.delStatus=1 where s.testId=:testId")
	int deleteTest(@Param("testId")int testId);
	
	TestDetails findByTestIdAndDelStatus(int testId,int delStatus);
}
