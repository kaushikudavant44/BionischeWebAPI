package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorAppointmentCount;


public interface DoctorAppointmentCountRepository extends JpaRepository<DoctorAppointmentCount, Integer>{
	
	@Query(value="SELECT COUNT(a.appoint_id) as total_app,(SELECT COUNT(appoint_id) FROM doctor_appointment  WHERE doctor_id=:doctorId AND DATE=:appDate AND STATUS=4) AS completed_app FROM doctor_appointment a  WHERE a.doctor_id=:doctorId AND a.date=:appDate AND (a.status!=2 AND a.status!=3)" ,nativeQuery=true)
	DoctorAppointmentCount getAppointmentCount(@Param("doctorId") int doctorId,@Param("appDate") String appDate);
}
