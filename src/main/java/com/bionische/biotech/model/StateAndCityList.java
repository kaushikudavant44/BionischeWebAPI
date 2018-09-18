package com.bionische.biotech.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class StateAndCityList {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="state_Id")
	private int stateId;
	
	@Column(name="country_Id")
	private int countryId;
	
	@Column(name="state_Name")
	private String stateName;

	@Transient
	private List<City> cityList;


	public int getStateId() {
		return stateId;
	}


	public void setStateId(int stateId) {
		this.stateId = stateId;
	}


	public int getCountryId() {
		return countryId;
	}


	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}


	public String getStateName() {
		return stateName;
	}


	public void setStateName(String stateName) {
		this.stateName = stateName;
	}


	public List<City> getCityList() {
		return cityList;
	}


	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}


	@Override
	public String toString() {
		return "StateAndCityList [stateId=" + stateId + ", countryId=" + countryId + ", stateName=" + stateName
				+ ", cityList=" + cityList + "]";
	}
	
	
}
