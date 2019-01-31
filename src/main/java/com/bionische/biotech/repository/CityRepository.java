package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bionische.biotech.model.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	
	List<City> findByStateId(int stateId);
	
	City findByCityId(int cityId);

	@Transactional
	int deleteByCityId(@Param("cityId")int cityId);
}
