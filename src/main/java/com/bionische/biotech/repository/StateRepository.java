package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bionische.biotech.model.City;
import com.bionische.biotech.model.State;

public interface StateRepository extends JpaRepository<State, Integer>{
	
	List<State> findByCountryId(int countryId);
}
