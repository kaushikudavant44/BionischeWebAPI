package com.bionische.biotech.history.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.history.model.PatientSystemHeader;

public interface PatientSystemHeaderRepository extends JpaRepository<PatientSystemHeader , Integer>{

	List<PatientSystemHeader> findByDelStatus(int delStatus);

}
