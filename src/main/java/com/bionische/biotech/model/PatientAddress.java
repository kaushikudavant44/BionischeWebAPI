package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientAddress {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="state_name")
	private String stateName;
	
	@Column(name="country_name")
	private String countryName;
	
	@Column(name="address")
	private String address;
	
	@Column(name="int_2")
	private int pincode;
	
	@Column(name="contact")
	private String contact;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "PatientAddress [cityName=" + cityName + ", stateName=" + stateName + ", countryName=" + countryName
				+ ", address=" + address + ", pincode=" + pincode + ", contact=" + contact + "]";
	}
	
	
}
