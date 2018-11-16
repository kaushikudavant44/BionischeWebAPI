package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetVerificationPendingCount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="id")
	private int id;

	@Column(name="doctor_count")
	private int doctorCount;

	@Column(name="lab_count")
	private int labCount;

	@Column(name="pharmacy_count")
	private int pharmacyCount;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoctorCount() {
		return doctorCount;
	}

	public void setDoctorCount(int doctorCount) {
		this.doctorCount = doctorCount;
	}

	public int getLabCount() {
		return labCount;
	}

	public void setLabCount(int labCount) {
		this.labCount = labCount;
	}

	public int getPharmacyCount() {
		return pharmacyCount;
	}

	public void setPharmacyCount(int pharmacyCount) {
		this.pharmacyCount = pharmacyCount;
	}

	@Override
	public String toString() {
		return "GetVerificationPendingCount [id=" + id + ", doctorCount=" + doctorCount + ", labCount=" + labCount
				+ ", pharmacyCount=" + pharmacyCount + "]";
	}
	
	
}
