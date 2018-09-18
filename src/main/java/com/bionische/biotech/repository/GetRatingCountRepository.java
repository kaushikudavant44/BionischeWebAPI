package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetRatingCount;

public interface GetRatingCountRepository extends JpaRepository<GetRatingCount, Integer> {
	
	@Query(value="SELECT COUNT(rating_review_id) as count,rating FROM rating_details WHERE doctor_id=:doctorId GROUP BY rating ASC ",nativeQuery=true)
	List<GetRatingCount> getRatingCount(@Param("doctorId")int doctorId);

	@Query(value="SELECT COUNT(rating_review_id) as count,rating FROM lab_rating_review WHERE lab_id=:labId GROUP BY rating ASC ",nativeQuery=true)
	List<GetRatingCount> getLabRatingCount(@Param("labId")int labId);
}
