package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	
	List<City> findByStateId(int stateId);
	
	City findByCityId(int cityId);

}
