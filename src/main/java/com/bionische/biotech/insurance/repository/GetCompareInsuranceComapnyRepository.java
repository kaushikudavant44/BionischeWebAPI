package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.insurance.model.GetCompareInsuranceComapny;

public interface GetCompareInsuranceComapnyRepository   extends JpaRepository<GetCompareInsuranceComapny, Integer>{

	 
	
	
	@Query(value=" SELECT * from insurance_company_feature where insurance_company_id=:companyId AND cover_amount=:cover AND del_status=0",nativeQuery=true)
	//List<GetCompareInsuranceComapny> getCompanyToCompare( @Param("companyId")String companyId);

	GetCompareInsuranceComapny getCompanyToCompare(@Param("companyId")int companyId, @Param("cover")int cover);
	
	
}
