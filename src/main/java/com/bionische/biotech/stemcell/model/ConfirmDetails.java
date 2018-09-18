package com.bionische.biotech.stemcell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class ConfirmDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "patientenroll_id")
	private int patientenrollId;
	
	@Column(name = "patient_id")            
	private int patientId;

	@Column(name = "pregnancy_type")    
	private String pregnancyType;

	@Column(name = "time")
	private String time;

	@Column(name = "date")
	private String date;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "country_id")
	private int countryId;

	@Column(name = "state_id")
	private int stateId;

	@Column(name = "city_id")
	private int cityId;

	@Column(name = "hospital_id")
	private int hospitalId;

	@Column(name = "state_name")
	private String stateName;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "hospital_name")
	private String hospitalName;

	@Column(name = "plan_id")
	private int planId;
	
	@Column(name = "delivery_date")
	private String expectedDeliveryDate;


	public int getPatientenrollId() {
		return patientenrollId;
	}

	public void setPatientenrollId(int patientenrollId) {
		this.patientenrollId = patientenrollId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPregnancyType() {
		return pregnancyType;
	}

	public void setPregnancyType(String pregnancyType) {
		this.pregnancyType = pregnancyType;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
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

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(String expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	
	@Override
	public String toString() {
		return "ConfirmDetails [patientenrollId=" + patientenrollId + ", patientId=" + patientId + ", pregnancyType="
				+ pregnancyType + ", time=" + time + ", date=" + date + ", countryName=" + countryName + ", countryId="
				+ countryId + ", stateId=" + stateId + ", cityId=" + cityId + ", hospitalId=" + hospitalId
				+ ", stateName=" + stateName + ", cityName=" + cityName + ", hospitalName=" + hospitalName + ", planId="
				+ planId + ", expectedDeliveryDate=" + expectedDeliveryDate + "]";
	}
	
	

	
}
