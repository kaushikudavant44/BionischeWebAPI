package com.bionische.biotech.yoga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.yoga.model.Pranayama;
import com.bionische.biotech.yoga.model.PranayamaDetails;
import com.bionische.biotech.yoga.model.Yoga;

public interface PranayamaRepository extends JpaRepository<Pranayama, Integer> {
	List<Pranayama> findAll();

	@Query(value=" SELECT * from pranayama where pranayamtype_id IN(:pranayamatypesIdList)",nativeQuery=true)
	List<Pranayama> getTypesDetails(@Param("pranayamatypesIdList")List<String> pranayamatypesIdList);


}
