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
	
	@Column(name="address")
	private String address;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
				+ ", address=" + address + ", patientId=" + patientId + "]";
	}
	
	

}
