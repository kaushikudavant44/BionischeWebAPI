package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.insurance.model.CompaniesOnAge;

public interface CompaniesOnAgeRepository extends JpaRepository<CompaniesOnAge, Integer> {

	@Query(value = "SELECT  DISTINCT p.premium_id,p.company_id,p.family,c.Insurance_company_name,"
			+ " COALESCE((select ((SUM(r.insurance_rating)*5)/(count(r.insurance_rating)*5)) from "
			+ " insurance_rating r where p.company_id=r.company_id),0) AS insurance_rating"
			+ " FROM insurance_company c,insurance_premium_table p WHERE "
			+ " p.family=:memberType AND p.age LIKE %:age% AND p.company_id=c.Insurance_company_id"
			+ " AND p.del_status=0 GROUP BY p.company_id", nativeQuery = true)
	List<CompaniesOnAge> getInsuranceCompanies(@Param("age") String age, @Param("memberType") String membersType);

	@Query(value = "SELECT  premium from insurance_premium_table where premium_id=:cover", nativeQuery = true)
	int getPremiumByCover(@Param("cover") int cover);

}
