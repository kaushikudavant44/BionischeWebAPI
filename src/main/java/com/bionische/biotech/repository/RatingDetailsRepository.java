package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.RatingDetails;

 

public interface RatingDetailsRepository extends JpaRepository<RatingDetails, Integer>{
	
	RatingDetails save(RatingDetails ratingDetails);

	
	@Query(value="select * from rating_details where del_status=:delStatus AND doctor_id IN(:doctorId)",nativeQuery=true)
	List<RatingDetails> getByDoctorIdAndDelStatus(@Param("doctorId")List<String> doctorId, @Param("delStatus")int delStatus);


	List<RatingDetails> findByDoctorId(int doctorId);

	@Transactional
	@Modifying
	@Query("UPDATE RatingDetails a SET a.delStatus =:delStatus  WHERE a.ratingReviewId=:ratingReviewId")
	 int updateRatingReviewStatus(@Param("ratingReviewId")int ratingReviewId, @Param("delStatus")int delStatus);

	@Query(value="select * from rating_details where del_status=:delStatus AND doctor_id=:doctorId",nativeQuery=true)
	List<RatingDetails> getRatingByDoctorId(@Param("doctorId")int doctorId, @Param("delStatus")int delStatus);
}
