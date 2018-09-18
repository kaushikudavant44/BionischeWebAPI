package com.bionische.biotech.insurance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.insurance.model.ChildMemberDetails;

public interface ChildMemberDetailsRepository extends JpaRepository<ChildMemberDetails, Integer>{

	ChildMemberDetails save(ChildMemberDetails childMemberDetails);
	
	@Query(value="SELECT * from insurance_child_member_details where insu_reg_id=:insuRegId",nativeQuery=true)
	List<ChildMemberDetails> getInsuranceChildInfoList(@Param("insuRegId")int insuRegId);
}
