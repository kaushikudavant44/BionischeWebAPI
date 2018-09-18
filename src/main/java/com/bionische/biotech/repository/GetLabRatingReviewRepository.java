package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.GetLabRatingReview;
import com.bionische.biotech.model.RatingDetails;

public interface GetLabRatingReviewRepository extends JpaRepository<GetLabRatingReview, Integer>{

	GetLabRatingReview save(GetLabRatingReview ratingDetails);
	
	List<GetLabRatingReview> findByLabIdAndDelStatus(int labId, int delStatus);

	
	List<GetLabRatingReview> findByLabId(int labId);
	
	@Transactional
	@Modifying
	@Query("UPDATE GetLabRatingReview a SET a.delStatus =:delStatus  WHERE a.ratingReviewId=:ratingReviewId")
	int updateDeleteStatus(@Param("ratingReviewId")int ratingReviewId, @Param("delStatus")int delStatus);
}
