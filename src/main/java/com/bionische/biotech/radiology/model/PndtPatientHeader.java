package com.bionische.biotech.radiology.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="pndt_patient_header")
public class PndtPatientHeader {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pndt_header_id")	
	int pndt_header_id;
	
	@Column(name="patient_id")
	int patient_id;
	
	@Column(name="month")
	int month;
	
	@Column(name="year")
	int year;
	
	@Column(name="doctor_id")
	int doctor_id;
	
	@Column(name="created_date",updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	Date created_date;
	
	@Column(name="modified_date")
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@UpdateTimestamp
	Date modified_date;

	public int getPndt_header_id() {
		return pndt_header_id;
	}

	public void setPndt_header_id(int pndt_header_id) {
		this.pndt_header_id = pndt_header_id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getModified_date() {
		return modified_date;
	}

	public void setModified_date(Date modified_date) {
		this.modified_date = modified_date;
	}

	@Override
	public String toString() {
		return "PndtPatientHeader [pndt_header_id=" + pndt_header_id + ", patient_id=" + patient_id + ", month=" + month
				+ ", year=" + year + ", doctor_id=" + doctor_id + ", created_date=" + created_date + ", modified_date="
				+ modified_date + "]";
	}
	
	
	
	
}
