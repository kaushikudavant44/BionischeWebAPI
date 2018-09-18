package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.insurance.model.CompaniesOnAge;
import com.bionische.biotech.insurance.model.MakePayment;

public interface MakePaymentRepository extends JpaRepository<MakePayment, Integer>{
	
	@Query(value="select insu_reg_id,insu_cover,insu_premium,Insurance_company_name from  insurance_registration_details r,insurance_company c where r.family_id=:familyId  and r.comp_id=c.Insurance_company_id and delstatus=0  ",nativeQuery=true)
	List<MakePayment> getBoughtInsuDetails(@Param("familyId")int familyId);

}
