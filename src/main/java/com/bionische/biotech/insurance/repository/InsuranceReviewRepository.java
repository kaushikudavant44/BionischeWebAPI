package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.insurance.model.InsuranceReview;

public interface InsuranceReviewRepository extends JpaRepository<InsuranceReview, Integer>{
	
	@Query(value="SELECT r.company_review_id, r.company_review, r.int_1, r.int_2, r.del_status,CONCAT(p.f_name, ' ',p.l_name) as patient_name, r.string1, r.string2,r.company_id,r.patient_id,r.date from insurance_review r,patient_details p where r.company_id=:companyId and r.patient_id=p.patient_id and r.del_status=0;" + 
			" ",nativeQuery=true)
	List<InsuranceReview> getReviewByCompanyId(@Param("companyId")int companyId);

	List<InsuranceReview> findByCompanyId(int companyId);

	
	@Transactional
	@Modifying
	@Query("UPDATE InsuranceReview a SET a.delStatus =:delStatus  WHERE a.reviewId=:ratingReviewId")
	int updateDeleteStatus(@Param("ratingReviewId")int ratingReviewId, @Param("delStatus")int delStatus);
}
