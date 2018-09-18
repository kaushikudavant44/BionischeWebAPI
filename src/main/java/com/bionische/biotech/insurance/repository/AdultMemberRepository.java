package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.insurance.model.AdultMember;

public interface AdultMemberRepository extends JpaRepository<AdultMember, Integer>{

	AdultMember save(AdultMember adultMember);
	
	@Query(value="SELECT * from insurance_adult_member_details where insu_reg_id=:insuRegId",nativeQuery=true)
	List<AdultMember> getInsuranceAdultInfoList(@Param("insuRegId")int insuRegId);
	
}
