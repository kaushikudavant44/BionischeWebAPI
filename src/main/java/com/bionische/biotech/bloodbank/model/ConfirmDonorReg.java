package com.bionische.biotech.bloodbank.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity


public class ConfirmDonorReg {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name="medication")
	private String medication;
	
	@Column(name = "country_name")
private String countryName;
	
	@Column(name = "country_id")
private int countryId;
	
	@Column(name = "state_id")
private int stateId;   
	    
	@Column(name = "city_id")
private int cityId;
	

	@Column(name = "state_name")
private String stateName;

	@Column(name = "city_name")
private String cityName;
	
	@Column(name="allergies")
private String allegries;
	
	@Column(name="positive_bloodtest")
private String positiveBloodTest;
	
	@Column(name="cardic_problem")
private String cardicProblem;
	
	
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAllegries() {
		return allegries;
	}
	public void setAllegries(String allegries) {
		this.allegries = allegries;
	}
	public String getPositiveBloodTest() {
		return positiveBloodTest;
	}
	public void setPositiveBloodTest(String positiveBloodTest) {
		this.positiveBloodTest = positiveBloodTest;
	}
	public String getCardicProblem() {
		return cardicProblem;
	}
	public void setCardicProblem(String cardicProblem) {
		this.cardicProblem = cardicProblem;
	}
	


	
	
	
	

	
}
