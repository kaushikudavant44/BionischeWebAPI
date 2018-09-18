package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.Country;
import com.bionische.biotech.model.State;

public interface CountryRepository extends JpaRepository<Country, Integer>{
	
	List<Country> findAll();
}
