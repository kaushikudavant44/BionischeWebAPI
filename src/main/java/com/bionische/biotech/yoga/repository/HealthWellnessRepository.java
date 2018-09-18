package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.Country;
import com.bionische.biotech.yoga.model.HealthWellness;
import com.bionische.biotech.yoga.model.Yoga;
import com.bionische.biotech.yoga.model.YogaTeacherDetails;

public interface HealthWellnessRepository extends JpaRepository<HealthWellness, Integer> {
	List<HealthWellness> findAll();

	@Query(value=" SELECT * from health_wellness where healthtype_id IN(:healthtypesIdList)",nativeQuery=true)
	

	//List<HealthWellness> getHealthTypesDetails(@Param("healthtypesIdList")List<String> healthtypesIdList);

	List<HealthWellness> getTypesDetails(@Param("healthtypesIdList")List<String> healthtypesIdList);
}
