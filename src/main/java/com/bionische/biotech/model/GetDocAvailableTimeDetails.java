package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bionische.biotech.Common.DateConverter;

@Entity
public class GetDocAvailableTimeDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="doc_available_time_id")
	private int docAvailableId;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="date")
	private String date;
	
	@Column(name="hospital_id")
	private int hospitalId;
	
	@Column(name="hospital_name")
	private String hospitalName;
	
	@Column(name="available_time")
	private String availableTime;
	
	@Column(name="no_of_patient")
	private int noOfPatient;
	
	@Column(name="address")
	private String address;
	
	@Column(name="type")
	private int type;

	public int getDocAvailableId() {
		return docAvailableId;
	}

	public void setDocAvailableId(int docAvailableId) {
		this.docAvailableId = docAvailableId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
 

	public String getDate() {
		return DateConverter.convertToDMY(date);
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public int getNoOfPatient() {
		return noOfPatient;
	}

	public void setNoOfPatient(int noOfPatient) {
		this.noOfPatient = noOfPatient;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@Override
	public String toString() {
		return "GetDocAvailableTimeDetails [docAvailableId=" + docAvailableId + ", doctorId=" + doctorId
				+ ", doctorName=" + doctorName + ", date=" + date + ", hospitalId=" + hospitalId + ", hospitalName="
				+ hospitalName + ", availableTime=" + availableTime + ", noOfPatient=" + noOfPatient + ", address="
				+ address + ", type=" + type + "]";
	}

	 
	
	
	
}
