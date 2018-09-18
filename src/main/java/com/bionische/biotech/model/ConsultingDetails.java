package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConsultingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="meet_id")
	private int meetId;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="patient_id")
	private int patintId;
	
	@Column(name="hospital_name")
	private String hospitalName;
	
	@Column(name="f_name")
	private String doctorName;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="patient_problem")
	private String patientProblem;
	
	@Column(name="discussion")
	private String discussion;
	
	@Column(name="note")
	private String note;
	
	@Column(name="patient_name")
	private String patientName;
	

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientProblem() {
		return patientProblem;
	}

	public void setPatientProblem(String patientProblem) {
		this.patientProblem = patientProblem;
	}


	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatintId() {
		return patintId;
	}

	public void setPatintId(int patintId) {
		this.patintId = patintId;
	}

	public int getMeetId() {
		return meetId;
	}

	public void setMeetId(int meetId) {
		this.meetId = meetId;
	}


	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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

	
	public String getDiscussion() {
		return discussion;
	}

	public void setDiscussion(String discussion) {
		this.discussion = discussion;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "ConsultingDetails [meetId=" + meetId + ", doctorId=" + doctorId + ", patintId=" + patintId
				+ ", hospitalName=" + hospitalName + ", doctorName=" + doctorName + ", date=" + date + ", time=" + time
				+ ", patientProblem=" + patientProblem + ", discussion=" + discussion + ", note=" + note
				+ ", patientName=" + patientName + "]";
	}
	
}
