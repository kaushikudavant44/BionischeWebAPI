package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name="from_time")
	private int fromTime;
	
	@Column(name="to_time")
	private int toTime;
	
	@Column(name="del_status")
	private int delStatus;

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
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getFromTime() {
		return fromTime;
	}

	public void setFromTime(int fromTime) {
		this.fromTime = fromTime;
	}

	public int getToTime() {
		return toTime;
	}

	public void setToTime(int toTime) {
		this.toTime = toTime;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "DocAvailableTime [docAvailableId=" + docAvailableId + ", doctorId=" + doctorId + ", date=" + date
				+ ", fromTime=" + fromTime + ", toTime=" + toTime + ", delStatus=" + delStatus + "]";
	}
	
	

}
