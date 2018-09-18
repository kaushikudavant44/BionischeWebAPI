package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.yoga.model.PranayamaDetails;
import com.bionische.biotech.yoga.model.YogaTeacherRatingDetails;
import com.bionische.biotech.yoga.model.YogaTypeDetails;

public interface PranayamaDetailsRepository extends JpaRepository<PranayamaDetails, Integer> {

	@Query(value="SELECT p.pranayamadetail_id,p.string1,p.int_1,p.int_2,p.pranayamtype_id,p.del_status,p.teacher_id,p.description,p.image from pranayama_details p where p.pranayamtype_id=:pranayamaTypeId",nativeQuery=true)

	List<PranayamaDetails> getPranayamaByPranayamaTypeId(@Param("pranayamaTypeId") int pranayamaTypeId);
}
