package com.bionische.biotech.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.bionische.biotech.Common.DateConverter;
@Entity
@Table(name="doctor_patient_meeting")
public class DoctorPatientMeeting {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="meet_id")
	private int meetId;
	
	@Column(name="doctor_id")
    private int doctorId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="time")
	private String time;
	
	@Column(name="date")
	private String date;
	
	@Column(name="discussion")
	private String discussion;
	
	@Column(name="patient_problem")
	private String patientProblem;
	
	@Column(name="note")
	private String note;
	
	@Column(name="string_1")
	private String string1;
	
	@Column(name="string_2")
	private String string2;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Transient
	List<PrescriptionDetails> prescriptionDetailsList;
	
	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	
	public int getMeetId() {
		return meetId;
	}

	public void setMeetId(int meetId) {
		this.meetId = meetId;
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
		return DateConverter.convertToDMY(date);
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	 

	public String getPatientProblem() {
		return patientProblem;
	}

	public void setPatientProblem(String patientProblem) {
		this.patientProblem = patientProblem;
	}

	public List<PrescriptionDetails> getPrescriptionDetailsList() {
		return prescriptionDetailsList;
	}

	public void setPrescriptionDetailsList(List<PrescriptionDetails> prescriptionDetailsList) {
		this.prescriptionDetailsList = prescriptionDetailsList;
	}

	@Override
	public String toString() {
		return "DoctorPatientMeeting [meetId=" + meetId + ", doctorId=" + doctorId + ", patientId=" + patientId
				+ ", time=" + time + ", date=" + date + ", discussion=" + discussion + ", patientProblem="
				+ patientProblem + ", note=" + note + ", string1=" + string1 + ", string2=" + string2 + ", int1=" + int1
				+ ", int2=" + int2 + ", prescriptionDetailsList=" + prescriptionDetailsList + "]";
	}
	

}
