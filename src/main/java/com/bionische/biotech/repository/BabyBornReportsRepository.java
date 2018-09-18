package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.BabyBornReports;

public interface BabyBornReportsRepository extends JpaRepository<BabyBornReports, Integer>{

	
	BabyBornReports save(BabyBornReports babyBornReports);
	
	BabyBornReports findByPatientId(int patientId);
	
	List<BabyBornReports> findByPatientIdAndDelStatus(int patientId, int delStatus);
}
