package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AppointmentReminder {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="appoint_id")
	private int appointId;

	private String date;
	
	private String time;
	
	private String doctorName;
	
	private String patientName;

	private String contact;
	
	private String hospitalName;
	
	private String contactNo;
	
	private int int1;
	
	private String string1;

	public int getAppointId() {
		return appointId;
	}

	public void setAppointId(int appointId) {
		this.appointId = appointId;
	}

	public String getDate() {
		return date;
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

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	@Override
	public String toString() {
		return "AppointmentReminder [appointId=" + appointId + ", date=" + date + ", time=" + time + ", doctorName="
				+ doctorName + ", patientName=" + patientName + ", contact=" + contact + ", hospitalName="
				+ hospitalName + ", contactNo=" + contactNo + ", int1=" + int1 + ", string1=" + string1 + "]";
	}






}
