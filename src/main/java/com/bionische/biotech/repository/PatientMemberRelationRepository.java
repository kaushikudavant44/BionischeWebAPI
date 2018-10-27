package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.bionische.biotech.model.PatientMemberRelation;

public interface PatientMemberRelationRepository extends JpaRepository<PatientMemberRelation, Integer>{
	
	@Query(value="SELECT *  FROM patient_member_relation",nativeQuery=true)
	List<PatientMemberRelation> getAllRelations();
	
	@Query(value="SELECT *  FROM patient_member_relation WHERE relation_type  NOT IN(:relations) ",nativeQuery=true)
	List<PatientMemberRelation> getRelations(@Param("relations")List<String> relations);

}
