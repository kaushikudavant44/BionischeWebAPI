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
	
	@Query(value="SELECT COALESCE((COUNT(rating_review_id)),0) as count,COALESCE(((SUM(rating)*5)/(count(rating_review_id)*5)),0) as rating from lab_rating_review  where lab_id=:labId" ,nativeQuery=true)
	GetRatingCount getLabRating(@Param("labId")int labId);
	
	@Query(value="SELECT COALESCE((COUNT(rating_review_id)),0) as count,COALESCE(((SUM(rating)*5)/(count(rating_review_id)*5)),0) as rating from rating_details  where doctor_id=:doctorId" ,nativeQuery=true)
	GetRatingCount getDoctorRating(@Param("doctorId")int doctorId);
}
