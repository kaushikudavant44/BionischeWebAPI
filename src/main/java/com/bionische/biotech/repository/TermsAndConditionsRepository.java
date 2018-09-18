package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.TermsAndConditions;

public interface TermsAndConditionsRepository extends JpaRepository<TermsAndConditions, Integer>{

	
	TermsAndConditions save(TermsAndConditions termsAndConditions);
	
	TermsAndConditions findByUserTypeAndDelStatus(int userType, int delStatus);
	
	@Query(value=" SELECT * form terms_and_conditions where term_and_condition_id=:termAndConditionId",nativeQuery=true)
	TermsAndConditions getByTermAndConditionId(@Param("termAndConditionId")int termAndConditionId);

}
