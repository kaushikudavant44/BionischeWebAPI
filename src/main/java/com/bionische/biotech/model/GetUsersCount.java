package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetUsersCount {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="lab_count")
	private int labCount;
	
	@Column(name="patient_count")
	private int patientCount;
	
	@Column(name="pharmacy_count")
	private int pharmacyCount;
	
	@Column(name="doctor_count")
	private int doctorCount;
	
	@Column(name="hospital_count")
	private int hospitalCount;

	public int getLabCount() {
		return labCount;
	}

	public void setLabCount(int labCount) {
		this.labCount = labCount;
	}

	public int getPatientCount() {
		return patientCount;
	}

	public void setPatientCount(int patientCount) {
		this.patientCount = patientCount;
	}

	public int getPharmacyCount() {
		return pharmacyCount;
	}

	public void setPharmacyCount(int pharmacyCount) {
		this.pharmacyCount = pharmacyCount;
	}

	public int getDoctorCount() {
		return doctorCount;
	}

	public void setDoctorCount(int doctorCount) {
		this.doctorCount = doctorCount;
	}

	public int getHospitalCount() {
		return hospitalCount;
	}

	public void setHospitalCount(int hospitalCount) {
		this.hospitalCount = hospitalCount;
	}

	@Override
	public String toString() {
		return "GetUsersCount [labCount=" + labCount + ", patientCount=" + patientCount + ", pharmacyCount="
				+ pharmacyCount + ", doctorCount=" + doctorCount + ", hospitalCount=" + hospitalCount + "]";
	}
	
	
}
