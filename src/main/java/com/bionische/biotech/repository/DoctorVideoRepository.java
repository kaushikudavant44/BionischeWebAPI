package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorVideo;


public interface DoctorVideoRepository extends JpaRepository<DoctorVideo, Integer>  {

	
	DoctorVideo  save(DoctorVideo doctorvideo);
	
	
	
	@Query(value=" SELECT * FROM video_calldetails where status=0 and patientid=:patientId AND datetime BETWEEN :fromDate AND :toDate",nativeQuery=true)
	DoctorVideo getvideoByPatientIdAndStatus(@Param("patientId")int patientId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);
	
	@Transactional
	@Modifying
	@Query("UPDATE DoctorVideo set status=1 where patientId=:patientId")
	int updateVideoBypatientId(@Param("patientId")int patientId);
}
