package com.bionische.biotech.stemcell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class GetStemCellsDetails {

	
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

 

	@Column(name = "stemcellbank_id")
	private int stemcellbankId;
	
	
	@Column(name = "stemcellbank_name")
	private String stemcellbankName;

 

	@Column(name = "country_id")
	private int countryId;

	@Column(name = "state_id")
	private int stateId;

	@Column(name = "city_id")
	private int cityId;

	@Column(name = "hospital_id")
	private int hospitalId;

 

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "hospital_name")
	private String hospitalName;

	@Column(name = "plan_id")
	private int planId;
	
	@Column(name = "delivery_date")
	private String expectedDeliveryDate;
	
	@Column(name="plan_type")
	private String planType;
	
	@Column(name="plan_name")
	private String planName;
	
	
	@Column(name="plan_cost")
	private String planCost;
	
	@Column(name="plan_days")
	private String planDays;

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

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanCost() {
		return planCost;
	}

	public void setPlanCost(String planCost) {
		this.planCost = planCost;
	}

	public String getPlanDays() {
		return planDays;
	}

	public void setPlanDays(String planDays) {
		this.planDays = planDays;
	}

	public int getStemcellbankId() {
		return stemcellbankId;
	}

	public void setStemcellbankId(int stemcellbankId) {
		this.stemcellbankId = stemcellbankId;
	}

	public String getStemcellbankName() {
		return stemcellbankName;
	}

	public void setStemcellbankName(String stemcellbankName) {
		this.stemcellbankName = stemcellbankName;
	}

	@Override
	public String toString() {
		return "GetStemCellsDetails [patientenrollId=" + patientenrollId + ", patientId=" + patientId
				+ ", pregnancyType=" + pregnancyType + ", time=" + time + ", date=" + date + ", stemcellbankId="
				+ stemcellbankId + ", stemcellbankName=" + stemcellbankName + ", countryId=" + countryId + ", stateId="
				+ stateId + ", cityId=" + cityId + ", hospitalId=" + hospitalId + ", cityName=" + cityName
				+ ", hospitalName=" + hospitalName + ", planId=" + planId + ", expectedDeliveryDate="
				+ expectedDeliveryDate + ", planType=" + planType + ", planName=" + planName + ", planCost=" + planCost
				+ ", planDays=" + planDays + "]";
	}

	 
}
