package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.insurance.model.InsuranceRating;

public interface InsuranceRatingRepository extends JpaRepository<InsuranceRating, Integer>{

	
	List<InsuranceRating> findByCompanyId(int companyId);

	

	@Transactional
	@Modifying
	@Query("UPDATE InsuranceRating a SET a.delStatus =:delStatus  WHERE a.ratingId=:ratingReviewId")
	int updateDeleteStatus(@Param("ratingReviewId")int ratingReviewId, @Param("delStatus")int delStatus);
}
