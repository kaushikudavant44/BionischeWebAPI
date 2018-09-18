package com.bionische.biotech.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.StateAndCityList;

public interface StateAndCityListRepository extends JpaRepository<StateAndCityList, Integer>{

	@Query(value=" SELECT state_Id, country_Id , state_Name  from state where country_Id=:countryId ",nativeQuery=true)
	List<StateAndCityList> getStateByCountryId(@Param("countryId")int countryId);
}
