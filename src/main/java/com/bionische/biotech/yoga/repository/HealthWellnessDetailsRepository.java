package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.yoga.model.HealthWellnessDetails;
import com.bionische.biotech.yoga.model.YogaTypeDetails;

public interface HealthWellnessDetailsRepository extends JpaRepository<HealthWellnessDetails, Integer> {
	
	@Query(value="SELECT h.healthtypedetail_id,h.healthtype_id,h.teacher_id,h.description,h.image from healthwellness_details h where h.healthtype_id=:healthTypeId",nativeQuery=true)

	List<HealthWellnessDetails> getHealthByHealthTypeId(@Param("healthTypeId") int healthTypeId);

}
