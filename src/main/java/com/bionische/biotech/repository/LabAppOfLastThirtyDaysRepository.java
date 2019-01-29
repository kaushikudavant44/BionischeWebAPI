package com.bionische.biotech.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.DoctorAppOfLastThirtyDays;
import com.bionische.biotech.model.LabAppOfLastThirtyDays;

public interface LabAppOfLastThirtyDaysRepository extends JpaRepository<LabAppOfLastThirtyDays, Integer>{
	
	@Query(value="SELECT a.lab_app_date AS app_date,COUNT(a.lab_app_id) AS total_app FROM lab_appointments a WHERE a.lab_id=:labId AND a.int_1=4 AND a.lab_app_date>:appDate GROUP BY a.lab_app_date" ,nativeQuery=true)
	List<LabAppOfLastThirtyDays> getLastThirtyDaysAppointment(@Param("labId") int labId,@Param("appDate") Date appDate);
}
