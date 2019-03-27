package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_doctor_circle")
public class DoctorCircle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="from_doctor_id")
	private int fromDoctorId;
	
	@Column(name="to_doctor_id")
	private int toDoctorId;
	
	@Column(name="status")
	private int status;

	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getFromDoctorId() {
		return fromDoctorId;
	}



	public void setFromDoctorId(int fromDoctorId) {
		this.fromDoctorId = fromDoctorId;
	}



	public int getToDoctorId() {
		return toDoctorId;
	}



	public void setToDoctorId(int toDoctorId) {
		this.toDoctorId = toDoctorId;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "DoctorCircle [id=" + id + ", fromDoctorId=" + fromDoctorId + ", toDoctorId=" + toDoctorId + ", status="
				+ status + "]";
	}
	
	
}
