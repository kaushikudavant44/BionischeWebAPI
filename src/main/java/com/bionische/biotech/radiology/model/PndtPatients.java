package com.bionische.biotech.radiology.model;





import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.bionische.biotech.Common.DateConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PndtPatients {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pndt_id")
	private int pndtId;

	@Column(name = "pndt_patient_id")
	private int pndtPatientId;

	@Column(name = "patient_name")
	private String patientName;

	@Column(name = "state")
	private String state;

	@Column(name = "name_of_doctor")
	private String nameOfDoctor;

	
	@Column(name = "created_date")
	private String createdDate;

	@Column(name = "status")
	private int status;

	public int getPndtPatientId() {
		return pndtPatientId;
	}

	public void setPndtPatientId(int pndtPatientId) {
		this.pndtPatientId = pndtPatientId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getPndtId() {
		return pndtId;
	}

	public void setPndtId(int pndtId) {
		this.pndtId = pndtId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getNameOfDoctor() {
		return nameOfDoctor;
	}

	public void setNameOfDoctor(String nameOfDoctor) {
		this.nameOfDoctor = nameOfDoctor;
	}

	public String getCreatedDate() {
		return DateConverter.convertToDMY(createdDate);
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "PndtPatients [pndtId=" + pndtId + ", pndtPatientId=" + pndtPatientId + ", patientName=" + patientName
				+ ", state=" + state + ", nameOfDoctor=" + nameOfDoctor + ", createdDate=" + createdDate + ", status="
				+ status + "]";
	}

}
