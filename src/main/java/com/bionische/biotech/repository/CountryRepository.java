package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bionische.biotech.model.Country;
import com.bionische.biotech.model.State;

public interface CountryRepository extends JpaRepository<Country, Integer>{
	
	/*List<Country> findAllOrderByCountryName();*/
	
	@Query(value="select * from country ORDER BY country_name ASC ",nativeQuery=true)
	
	List<Country> getAllOrderByCountryName();
}
