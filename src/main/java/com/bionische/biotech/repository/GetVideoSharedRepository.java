package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetVideoShared;

public interface GetVideoSharedRepository extends JpaRepository<GetVideoShared, Integer>{

	

	
	@Query(value="Select v.*, CONCAT(p.f_name,' ',p.l_name)as patient_name, CONCAT(d.f_name,' ',d.l_name)as doctor_name"
			+ " from t_video_share v, patient_details p, doctor_details d where v.video_id=:videoId AND v.patient_id=p.patient_id AND v.doctor_id=d.doctor_id AND v.del_status=0;",nativeQuery=true)
	GetVideoShared getSharedVideoById(@Param("videoId")int videoId);
	
	@Query(value="Select v.*, CONCAT(p.f_name,' ',p.l_name)as patient_name, CONCAT(d.f_name,' ',d.l_name)as doctor_name"
			+ " from t_video_share v, patient_details p, doctor_details d where v.patient_id=:patientId AND v.patient_id=p.patient_id AND v.doctor_id=d.doctor_id AND v.del_status=0 order by v.video_id desc;",nativeQuery=true)
	List<GetVideoShared> getLast10SharedVideo(@Param("patientId")int patientId);
	
}
