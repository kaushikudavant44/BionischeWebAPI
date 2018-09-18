package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.insurance.model.InsurancePremium;

public interface InsurancePremiumRepository extends JpaRepository<InsurancePremium, Integer>{
	
	
	@Query(value="Select * from insurance_premium_table where del_status=0 AND company_id=:companyId GROUP BY cover;",nativeQuery=true)
	List<InsurancePremium> getInsuranceCoverList(@Param("companyId")int companyId);

	List<InsurancePremium> findByCompanyIdAndCover(int companyId, int cover);

	@Query(value="Select * from insurance_premium_table where del_status=0 AND company_id=:insuranceCompanyId GROUP BY family;",nativeQuery=true)
	List<InsurancePremium> getFamilyTypesByCompanyId(@Param("insuranceCompanyId")int insuranceCompanyId);

	@Query(value="Select * from insurance_premium_table where del_status=0 AND company_id=:insuranceCompanyId GROUP BY age;",nativeQuery=true)
	List<InsurancePremium> getAgeGroupByCompanyId(@Param("insuranceCompanyId")int insuranceCompanyId);
 
}
