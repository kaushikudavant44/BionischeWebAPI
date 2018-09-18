package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.yoga.model.YogaTeacherRatingDetails;
import com.bionische.biotech.yoga.model.YogaTypeDetails;

public interface YogaTypeDetailsRepository extends JpaRepository<YogaTypeDetails, Integer> {

	@Query(value="SELECT u.yogatype_id,u.type_id,u.teacher_id,u.description,u.image from yogatype_details u where u.type_id=:typeId",nativeQuery=true)
	List<YogaTypeDetails> getEventsByTypeId(@Param("typeId")int typeId);
}
