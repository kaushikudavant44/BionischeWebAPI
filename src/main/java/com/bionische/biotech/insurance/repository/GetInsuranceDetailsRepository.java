package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.insurance.model.GetInsuranceDetails;

public interface GetInsuranceDetailsRepository extends JpaRepository<GetInsuranceDetails, Integer>{

	@Query(value="SELECT i.*, c.city_name, s.state_name, co.country_name, ic.Insurance_company_name from insurance_company ic, insurance_registration_details i, "
			+ "city c, country co, state s where i.registration_date BETWEEN :fromDate AND :toDate AND i.family_id=:familyId AND i.permanant_city_id=c.city_id"
			+ " AND i.permanant_state_id=s.state_id AND i.country_id=co.country_id AND i.comp_id=ic.Insurance_company_id",nativeQuery=true)
	List<GetInsuranceDetails> getInsuranceDetails(@Param("familyId")int familyId, @Param("fromDate")String fromDate,@Param("toDate")String toDate);
}
