package com.bionische.biotech.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bionische.biotech.model.City;
import com.bionische.biotech.model.StateAndCityList;
import com.bionische.biotech.repository.CityRepository;
import com.bionische.biotech.repository.StateAndCityListRepository;

@RestController
public class DataInitializationApiController {

	@Autowired
	StateAndCityListRepository stateAndCityListRepository;
	
	@Autowired
	CityRepository cityRepository;
	
	@RequestMapping(value = { "/getStatesAndCityByCountryId" }, method = RequestMethod.POST)
	public @ResponseBody List<StateAndCityList> getStatesAndCityByCountryId(@RequestParam("countryId") int countryId)
	{
		 List<StateAndCityList> stateAndCityList=new ArrayList<StateAndCityList>();
		
		 try {
			 stateAndCityList=stateAndCityListRepository.getStateByCountryId(countryId);
		 }
		 catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		 try {
			 for(int i=0;i<stateAndCityList.size();i++)
			 { 
				 List<City> citylist=new ArrayList<City>();
				 
			  citylist=cityRepository.findByStateIdOrderByCityNameAsc(stateAndCityList.get(i).getStateId());
			  
			  stateAndCityList.get(i).setCityList(citylist);
			 }
			 
			 
		 }catch (Exception e) {
			System.out.println(e.getMessage());// TODO: handle exception
		}
		 return stateAndCityList;
	}
}
