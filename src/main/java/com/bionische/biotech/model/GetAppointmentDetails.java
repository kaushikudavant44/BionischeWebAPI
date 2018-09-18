package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class GetAppointmentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="appoint_id")
	private int appointId;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="time_id")
	private int timeId;
	

	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="time")
	private String time;
	
	@Column(name="date")
	private String date;
	
	@Column(name="hospital_id")
    private String hospitalId;
	
	@Column(name="hospital_name")
	private String hospitalName;
	
	@Column(name="address")
	private String hospitalAddress;
	
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="patient_name")
	private String patientName; 
	
	@Column(name="profile_photo")
	private String profilePhoto; 
	
	@Column(name="del_status")
    private int delStatus;

	@Column(name="status")
    private int status;
	
	@Column(name="int_1")
	private int int_1;
	
	

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public int getAppointId() {
		return appointId;
	}

	public void setAppointId(int appointId) {
		this.appointId = appointId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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

	public String getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	public int getInt_1() {
		return int_1;
	}

	public void setInt_1(int int_1) {
		this.int_1 = int_1;
	}

	public int getTimeId() {
		return timeId;
	}

	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}

	@Override
	public String toString() {
		return "GetAppointmentDetails [appointId=" + appointId + ", doctorId=" + doctorId + ", timeId=" + timeId
				+ ", patientId=" + patientId + ", time=" + time + ", date=" + date + ", hospitalId=" + hospitalId
				+ ", hospitalName=" + hospitalName + ", hospitalAddress=" + hospitalAddress + ", doctorName="
				+ doctorName + ", patientName=" + patientName + ", profilePhoto=" + profilePhoto + ", delStatus="
				+ delStatus + ", status=" + status + ", int_1=" + int_1 + "]";
	}
	
	
	
}
