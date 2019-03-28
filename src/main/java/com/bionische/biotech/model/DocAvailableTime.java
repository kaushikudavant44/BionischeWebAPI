package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;

@Entity
@Table(name="doc_available_time")
public class DocAvailableTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="doc_available_time_id")
	private int docAvailableId;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="date")
	private String date;
 
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="hospital_id")
	private int hospitalId;
	
	@Column(name="available_time")
	private String availableTime;
	
	@Column(name="no_of_patient")
	private int noOfPatient;

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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
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

	@Override
	public String toString() {
		return "DocAvailableTime [docAvailableId=" + docAvailableId + ", doctorId=" + doctorId + ", date=" + date
				+ ", delStatus=" + delStatus + ", hospitalId=" + hospitalId + ", availableTime=" + availableTime
				+ ", noOfPatient=" + noOfPatient + "]";
	}

	 
 
	 

 
	 
	

}
