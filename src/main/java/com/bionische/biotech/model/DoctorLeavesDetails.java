package com.bionische.biotech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="t_doctor_leaves")
public class DoctorLeavesDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int leaveId;
	
	private int doctorId;

	
	private String date;

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
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

	@Override
	public String toString() {
		return "DoctorLeavesDetails [leaveId=" + leaveId + ", doctorId=" + doctorId + ", date=" + date + "]";
	}

	 
	
}
