 package com.bionische.biotech.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.history.model.PatientSystemReviews;
import com.bionische.biotech.history.model.PersonalHistoryDetails;

public interface PatientSystemReviewsRepository extends JpaRepository<PatientSystemReviews, Integer>{

	//PatientSystemReviews save(PatientSystemReviews patientSystemReviews);
	
	PatientSystemReviews findByPatientId(int patientId);

	PatientSystemReviews findByPatientIdAndDelStatus(int patientId, int delStatus);

	
}
