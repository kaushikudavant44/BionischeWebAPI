package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.stemcell.model.GetStemcellBankDetails;
import com.bionische.biotech.yoga.model.GetYogaTeacherDetails;

public interface GetYogaTeacherDetailsRepository extends JpaRepository<GetYogaTeacherDetails, Integer> {


	@Query(value="SELECT y.teacher_id,y.institute_name,y.city_id,y.contact,y.f_name,y.location,y.l_name,y.m_name,y.experience,y.education,y.profile_photo, y.address,y.email,COALESCE((select ((SUM(r.rating)*5)/(count(r.rating_review_id)*5)) from yogateacherrating_details r where r.teacher_id=y.teacher_id),0) AS rating from yogateacher_details y where y.location=:location",nativeQuery=true)


	List<GetYogaTeacherDetails> getTeacherListBylocation(@Param("location") String location);

	}
