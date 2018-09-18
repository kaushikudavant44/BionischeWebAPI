package com.bionische.biotech.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.insurance.model.InsuranceCompanyDetails;

public interface InsuranceCompanyDetailsRepository extends JpaRepository<InsuranceCompanyDetails, Integer>{

	@Query(value="SELECT Insurance_company_name from insurance_company where Insurance_company_id=:companyId",nativeQuery=true)
	String getCompanyName(@Param("companyId")int companyId);
	
	
	InsuranceCompanyDetails findByInsuranceCompanyId(int insuranceCompanyId);

}
