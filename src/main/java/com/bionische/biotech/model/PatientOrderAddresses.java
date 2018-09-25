package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PatientOrderAddresses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="medical_request_id")
	private int medicalRequestId;
	
	@Column(name="patient_contact")
	private String contact;
	
	@Column(name="city")
	private String city;
	
	@Column(name="land_mark")
	private String landmark;
	
	@Column(name="address")
	private String adderss;
	
	@Column(name="pincode")
	private int pincode;

	public int getMedicalRequestId() {
		return medicalRequestId;
	}

	public void setMedicalRequestId(int medicalRequestId) {
		this.medicalRequestId = medicalRequestId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getAdderss() {
		return adderss;
	}

	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "PatientOrderAddresses [medicalRequestId=" + medicalRequestId + ", contact=" + contact + ", city=" + city
				+ ", landmark=" + landmark + ", adderss=" + adderss + ", pincode=" + pincode + "]";
	}

}
