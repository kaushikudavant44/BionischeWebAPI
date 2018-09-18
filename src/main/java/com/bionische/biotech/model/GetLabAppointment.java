package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetLabAppointment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="lab_app_id")
	private int appointId;
	
	
	@Column(name="lab_test_id")
	private int labTestId;
	
	@Column(name="lab_test_name")
	private String labTestName;
	
	@Column(name="lab_id")
	private int labId;
	
	@Column(name="lab_name")
	private String labName;

	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="time")
	private String time;
	
	@Column(name="time_id")
	private int timeId;
	
	@Column(name="	lab_app_date")
	private String date;
	
	@Column(name="address")
	private String labAddress;
	
	@Column(name="patient_name")
	private String patientName; 
	
	@Column(name="patient_contact")
	private String patientContact; 
	
	@Column(name="del_status")
    private int delStatus;

	@Column(name="patient_email")
	private String patientEmail;

	@Column(name="int_1")
	private int int1;

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}



	public int getTimeId() {
		return timeId;
	}



	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}



	public int getAppointId() {
		return appointId;
	}



	public void setAppointId(int appointId) {
		this.appointId = appointId;
	}



	public String getLabName() {
		return labName;
	}



	public void setLabName(String labName) {
		this.labName = labName;
	}



	public int getPatientId() {
		return patientId;
	}



	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}



	public String getTime() {
		return time;
	}



	public void setTime(String time) {
		this.time = time;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getLabAddress() {
		return labAddress;
	}



	public void setLabAddress(String labAddress) {
		this.labAddress = labAddress;
	}



	public String getPatientName() {
		return patientName;
	}



	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}



	public String getPatientContact() {
		return patientContact;
	}



	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}



	public int getDelStatus() {
		return delStatus;
	}



	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}



	public String getPatientEmail() {
		return patientEmail;
	}



	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}



	public int getLabId() {
		return labId;
	}



	public void setLabId(int labId) {
		this.labId = labId;
	}



	public int getLabTestId() {
		return labTestId;
	}



	public void setLabTestId(int labTestId) {
		this.labTestId = labTestId;
	}



	public String getLabTestName() {
		return labTestName;
	}



	public void setLabTestName(String labTestName) {
		this.labTestName = labTestName;
	}



	@Override
	public String toString() {
		return "GetLabAppointment [appointId=" + appointId + ", labTestId=" + labTestId + ", labTestName=" + labTestName
				+ ", labId=" + labId + ", labName=" + labName + ", patientId=" + patientId + ", time=" + time
				+ ", timeId=" + timeId + ", date=" + date + ", labAddress=" + labAddress + ", patientName="
				+ patientName + ", patientContact=" + patientContact + ", delStatus=" + delStatus + ", patientEmail="
				+ patientEmail + "]";
	}


	
}
