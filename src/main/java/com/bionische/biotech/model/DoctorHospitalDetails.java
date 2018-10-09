package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor_hospital_details")
public class DoctorHospitalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="hospital_id")
	private int hospitalId;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="string1")
	private int string1;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getString1() {
		return string1;
	}

	public void setString1(int string1) {
		this.string1 = string1;
	}

	@Override
	public String toString() {
		return "DoctorHospitalDetails [id=" + id + ", doctorId=" + doctorId + ", hospitalId=" + hospitalId
				+ ", delStatus=" + delStatus + ", int1=" + int1 + ", string1=" + string1 + "]";
	}
	
	
}
