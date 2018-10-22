package com.bionische.biotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.DoctorAudio;


public interface DoctorAudioRepository  extends JpaRepository<DoctorAudio, Integer> {


	DoctorAudio  save(DoctorAudio doctorAudio);
	
	
	
	@Query(value=" SELECT * FROM audio_calldetails where status=0 and patientid=:patientId AND datetime BETWEEN :fromDate AND :toDate",nativeQuery=true)
	DoctorAudio getaudioByPatientIdAndStatus(@Param("patientId")int patientId, @Param("fromDate")String fromDate, @Param("toDate")String toDate);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE DoctorAudio set status=1 where patientId=:patientId")
	int updateAudioBypatientId(@Param("patientId")int patientId);
	
}
