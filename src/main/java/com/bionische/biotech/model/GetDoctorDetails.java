package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetDoctorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="appoint_id")
	int appId;
	
	@Column(name="doctor_id")
	int doctorId;
	
	@Column(name="f_name")
	String doctorfName;
	
	@Column(name="l_name")
	String doctorlName;
	
	@Column(name="m_name")
	String doctormName;
	
	@Column(name="hospital_Id")
	int hospitalId;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorfName() {
		return doctorfName;
	}

	public void setDoctorfName(String doctorfName) {
		this.doctorfName = doctorfName;
	}

	public String getDoctorlName() {
		return doctorlName;
	}

	public void setDoctorlName(String doctorlName) {
		this.doctorlName = doctorlName;
	}

	public String getDoctormName() {
		return doctormName;
	}

	public void setDoctormName(String doctormName) {
		this.doctormName = doctormName;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public String toString() {
		return "GetDoctorDetails [appId=" + appId + ", doctorId=" + doctorId + ", doctorfName=" + doctorfName
				+ ", doctorlName=" + doctorlName + ", doctormName=" + doctormName + ", hospitalId=" + hospitalId + "]";
	}
	
	
}
