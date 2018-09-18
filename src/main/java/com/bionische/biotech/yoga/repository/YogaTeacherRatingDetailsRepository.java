package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.stemcell.model.StemCellBankRatingDetails;
import com.bionische.biotech.yoga.model.YogaTeacherRatingDetails;

public interface YogaTeacherRatingDetailsRepository extends JpaRepository<YogaTeacherRatingDetails, Integer> {


	List<YogaTeacherRatingDetails> findByteacherIdAndDelStatus(int teacherId, int i);
	
	/*
	@Query(value="select * from yogateacherrating_details where del_status=:delStatus AND teacher_id IN(:teacherId)",nativeQuery=true)
	List<YogaTeacherRatingDetails> getByYogaTeacherIdAndDelStatus(@Param("teacherId")List<String> teacher_id, @Param("delStatus")int delStatus);*/
	

}
