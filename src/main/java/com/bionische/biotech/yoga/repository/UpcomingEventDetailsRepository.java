package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.Country;
import com.bionische.biotech.yoga.model.BmiCalculatorDetails;
import com.bionische.biotech.yoga.model.GetYogaTeacherDetails;
import com.bionische.biotech.yoga.model.UpcomingEventDetails;

public interface UpcomingEventDetailsRepository extends JpaRepository<UpcomingEventDetails, Integer> {
	
	UpcomingEventDetails save(UpcomingEventDetails upcomingEventDetails);
	
	@Query(value="SELECT u.event_id,u.del_status,u.date,u.teacher_id,u.time,u.description,u.image,u.event_name,u.location from upcoming_events u where u.teacher_id=:teacherId",nativeQuery=true)
	
    List<UpcomingEventDetails> getEventsByteacherId(@Param("teacherId") int teacherId);


	List<UpcomingEventDetails> findAll();

}
