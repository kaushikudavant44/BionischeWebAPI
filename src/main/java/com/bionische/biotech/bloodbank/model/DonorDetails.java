package com.bionische.biotech.bloodbank.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;

@Entity
@Table(name="donor_details")
public class DonorDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
@Column(name="donor_id")
	private int donorId;
	       
	@Column(name="city_id")
private int cityId;
	
	@Column(name="state_id")
private int stateId;
	     

	@Column(name="country_id")
private int countryId;

	@Column(name="string1")
private String string1;
	
	@Column(name="date")
	private String date;
		
	public String getDate() {
		return DateConverter.convertToDMY(date);
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}



	@Column(name="time")
	private String time;
		
	
@Column(name="patient_id")
private int patientId;
		
	
	@Column(name="string2")
private String string2;
	
	@Column(name="int_1")
private int int1;
	
	@Column(name="int_2")
private int int2;
	
	@Column(name="del_status")
private int delStatus;
	
	
@Column(name="allergies")
private String allegries;
		
@Column(name="positive_bloodtest")
private String positiveBloodTest;
		

@Column(name="cardic_problem")
private String cardicProblem;

@Column(name="medication")
private String medication;


	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

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

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	@Override
	public String toString() {
		return "DonorDetails [donorId=" + donorId + ", cityId=" + cityId + ", stateId=" + stateId + ", countryId="
				+ countryId + ", string1=" + string1 + ", date=" + date + ", time=" + time + ", patientId=" + patientId
				+ ", string2=" + string2 + ", int1=" + int1 + ", int2=" + int2 + ", delStatus=" + delStatus
				+ ", allegries=" + allegries + ", positiveBloodTest=" + positiveBloodTest + ", cardicProblem="
				+ cardicProblem + ", medication=" + medication + "]";
	}

	

	
	

}
