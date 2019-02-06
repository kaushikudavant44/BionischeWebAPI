package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fix_doctor_schedule")
public class FixDoctorAppointSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="schedule_id")
	int scheduleId;
	
	@Column(name="doctor_id")
	int doctorId;
	
	@Column(name="hospital_id")
	int clinicId;
	
	@Column(name="no_of_patient")
	int noOfPatient;
	
	@Column(name="time_json")
	String timeJson;
	
	@Column(name="del_status")
	int delStatus;
	
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public int getClinicId() {
		return clinicId;
	}
	public void setClinicId(int clinicId) {
		this.clinicId = clinicId;
	}
	public String getTimeJson() {
		return timeJson;
	}
	public void setTimeJson(String timeJson) {
		this.timeJson = timeJson;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public int getNoOfPatient() {
		return noOfPatient;
	}
	public void setNoOfPatient(int noOfPatient) {
		this.noOfPatient = noOfPatient;
	}
	@Override
	public String toString() {
		return "FixDoctorAppointSchedule [scheduleId=" + scheduleId + ", doctorId=" + doctorId + ", clinicId="
				+ clinicId + ", noOfPatient=" + noOfPatient + ", timeJson=" + timeJson + ", delStatus=" + delStatus
				+ "]";
	}
	 
	
	
	
}
