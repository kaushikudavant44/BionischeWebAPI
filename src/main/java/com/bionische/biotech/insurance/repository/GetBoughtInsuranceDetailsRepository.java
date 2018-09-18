package com.bionische.biotech.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.insurance.model.GetBoughtInsuranceDetails;

public interface GetBoughtInsuranceDetailsRepository extends JpaRepository<GetBoughtInsuranceDetails, Integer>{

	
	@Query(value="SELECT p.insu_reg_id, p.registration_date, p.due_date, p.insu_premium, p.comp_id, c.Insurance_company_name ,p.no_of_adult, p.no_of_child, p.insu_cover, p.app_status, p.int_1, p.int_2, p.string1, p.string2\r\n" + 
			"from insurance_registration_details p, insurance_company c where p.insu_reg_id=:insuRegId AND p.comp_id=c.insurance_company_id",nativeQuery=true)
	GetBoughtInsuranceDetails getBoughtInsuranceDetails(@Param("insuRegId")int insuRegId);
}
