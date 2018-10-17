package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_address_list")
public class PatientAddressList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="patient_address_list_id")
	private int patientAddressListId;
	
	@Column(name="pincode")
	private int pincode;
	
	@Column(name="full_name")
    private String fullName;
	
	@Column(name="locality")
	private String locality;
	
	@Column(name="house")
	private String house;
	
	@Column(name="street")
	private String street;
	
	@Column(name="country")
	private String country;
	
	@Column(name="state")
	private String state;
	
	@Column(name="city")
	private String city;
	
	@Column(name="contact_no")
	private String contactNo;
	
	@Column(name="patient_id")
	private int patientId;

	public int getPatientAddressListId() {
		return patientAddressListId;
	}

	public void setPatientAddressListId(int patientAddressListId) {
		this.patientAddressListId = patientAddressListId;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "PatientAddressList [patientAddressListId=" + patientAddressListId + ", pincode=" + pincode
				+ ", fullName=" + fullName + ", locality=" + locality + ", house=" + house + ", street=" + street
				+ ", country=" + country + ", state=" + state + ", city=" + city + ", contactNo=" + contactNo
				+ ", patientId=" + patientId + "]";
	}

	
	

}
