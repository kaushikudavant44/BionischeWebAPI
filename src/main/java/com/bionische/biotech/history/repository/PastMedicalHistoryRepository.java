package com.bionische.biotech.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.history.model.PastMedicalHistory;

public interface PastMedicalHistoryRepository extends JpaRepository<PastMedicalHistory, Integer>{

	//PastMedicalHistory save(PastMedicalHistory pastMedicalHistory);
	
	PastMedicalHistory findByPatientId(int patientId);

	PastMedicalHistory findByPatientIdAndDelStatus(int patientId, int delstatus);
}
