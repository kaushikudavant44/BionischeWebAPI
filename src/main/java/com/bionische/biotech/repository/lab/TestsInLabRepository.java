package com.bionische.biotech.repository.lab;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.lab.TestsInLab;

public interface TestsInLabRepository extends JpaRepository<TestsInLab, Integer>{

	TestsInLab findByLabIdAndTestId(int labId, int testId);
	TestsInLab save(TestsInLab testsInLab);
	
	List<TestsInLab> findByLabIdAndDelStatus(int labId, int delStatus);
	

	@Transactional
	@Modifying
	@Query("UPDATE TestsInLab  SET delStatus =:delStatus WHERE labId=:labId AND testId=:testId")
	  int updateDelStatus(int labId, int testId, int delStatus);
	
	
}
