package com.bionische.biotech.yoga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.yoga.model.EventRegistration;
import com.bionische.biotech.yoga.model.GetYogaTeacherDetails;
import com.bionische.biotech.yoga.model.YogaTeacherDetails;

public interface EventRegistrationRepository extends JpaRepository<EventRegistration, Integer> {
	
	EventRegistration save(EventRegistration eventRegistration);


}
