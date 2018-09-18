package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.insurance.model.CoverDetails;

public interface CoverDetailsRepository  extends JpaRepository<CoverDetails, Integer>{
	
	@Query(value="select premium_id,cover,premium from insurance_premium_table where company_id=:companyId AND age LIKE %:age% AND family=:membersType AND del_status=0",nativeQuery=true)
	List<CoverDetails> getCompaniesCover(@Param("companyId")int companyId,@Param("age")String age,@Param("membersType")String membersType);
	
	
}
