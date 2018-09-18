package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorPatientMeeting;

public interface DoctorPatientMeetingRepository extends JpaRepository<DoctorPatientMeeting, Integer>{

	
	DoctorPatientMeeting save(DoctorPatientMeeting doctorPatientMeeting);
	
	@Transactional
	@Modifying
	@Query("UPDATE DoctorPatientMeeting m SET m.int1 =1  WHERE m.meetId=:meetId")
	int updateRatingStatus(@Param("meetId")int meetId);

}
