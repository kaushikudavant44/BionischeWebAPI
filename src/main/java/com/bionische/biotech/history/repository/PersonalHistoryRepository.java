package com.bionische.biotech.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.history.model.PersonalHistoryDetails;

public interface PersonalHistoryRepository extends JpaRepository<PersonalHistoryDetails, Integer>{

	PersonalHistoryDetails save(PersonalHistoryDetails personalHistoryDetails);
	
	PersonalHistoryDetails findByPatientId(int patientId);
}
