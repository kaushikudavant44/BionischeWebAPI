package com.bionische.biotech.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorAppOfLastThirtyDays;


public interface DoctorAppOfLastThirtyDaysRepository extends JpaRepository<DoctorAppOfLastThirtyDays, Integer>{
	
	@Query(value="SELECT a.date as app_date,COUNT(a.appoint_id) as total_app FROM doctor_appointment a WHERE a.doctor_id=:doctorId AND a.status=4 AND MONTH(a.date)=:month AND YEAR(a.date)=:year GROUP BY a.date" ,nativeQuery=true)
	List<DoctorAppOfLastThirtyDays> getLastThirtyDaysAppointment(@Param("doctorId") int doctorId,@Param("month") int month, @Param("year") int year);
}
