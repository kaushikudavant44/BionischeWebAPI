package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.AppointmentDetails;
import com.bionische.biotech.model.DocAvailableTime;

public interface DocAvailableTimeRepository extends JpaRepository<DocAvailableTime, Integer> {
	
	DocAvailableTime  save(DocAvailableTime docAvailableTime);
	

@Query(value=" SELECT * from doc_available_time where doctor_id=:doctorId AND date=:date AND del_status=0",nativeQuery=true)
DocAvailableTime getAvailableTimeDBYDoctorId(@Param("doctorId")int doctorId, @Param("date")String date);

@Query(value=" SELECT * from doc_available_time where doctor_id=:doctorId AND date>=:date ",nativeQuery=true)
List<DocAvailableTime> getAllTimeBYDoctorId(@Param("doctorId")int doctorId,@Param("date")String date);

@Transactional
@Modifying
@Query("UPDATE DocAvailableTime d SET d.date=:date,d.fromTime=:fromTime,d.toTime=:toTime  WHERE d.docAvailableId=:docAvailableId")
int updateAvailableTime(@Param("docAvailableId")int docAvailableId, @Param("date")String date, @Param("fromTime")int fromTime, @Param("toTime")int toTime);

}
