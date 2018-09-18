package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.Country;
import com.bionische.biotech.model.LabTests;
import com.bionische.biotech.yoga.model.Yoga;
import com.bionische.biotech.yoga.model.YogaTeacherDetails;

public interface YogaRepository extends JpaRepository<Yoga, Integer> {
	List<Yoga> findAll();
	
	@Query(value=" SELECT * from yoga_details where type_id IN(:yogatypesIdList)",nativeQuery=true)

	List<Yoga> getTypesDetails(@Param("yogatypesIdList")List<String> yogatypesIdList);
}
