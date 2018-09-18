package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.insurance.model.CompaniesOnAge;
import com.bionische.biotech.insurance.model.CompanyFeatures;

public interface CompanyFeaturesReposiory extends JpaRepository<CompanyFeatures, Integer>{
	
	
	@Query(value="SELECT * from insurance_company_feature where insurance_company_id=:companyId",nativeQuery=true)
	List<CompanyFeatures> getFeaturesById(@Param("companyId")int companyId);

}
