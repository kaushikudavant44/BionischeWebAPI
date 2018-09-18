package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.yoga.model.GetUpcomingEvent;
import com.bionische.biotech.yoga.model.GetYogaTeacherDetails;
import com.bionische.biotech.yoga.model.Yoga;

public interface GetUpcomingEventRepository extends JpaRepository<GetUpcomingEvent, Integer> {

	
	@Query(value="SELECT u.event_id,u.teacher_id,u.event_name,y.f_name,y.l_name,u.date,u.time,u.location,u.description,u.image,u.del_status,y.teacher_id from upcoming_events u,yogateacher_details y where u.teacher_id=y.teacher_id",nativeQuery=true)

List<GetUpcomingEvent> findAll();
}
