package com.bionische.biotech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="t_suggest_lab_test_from_doctor")
public class SuggestLabTestFromDoctor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int suggestId;
	
	private int doctorId;
	
	private int patientId;
	
	private String testIdList;
	
	private int labId;

	public int getSuggestId() {
		return suggestId;
	}

	public void setSuggestId(int suggestId) {
		this.suggestId = suggestId;
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

	public String getTestIdList() {
		return testIdList;
	}

	public void setTestIdList(String testIdList) {
		this.testIdList = testIdList;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	@Override
	public String toString() {
		return "SuggestLabTestFromDoctor [suggestId=" + suggestId + ", doctorId=" + doctorId + ", patientId="
				+ patientId + ", testIdList=" + testIdList + ", labId=" + labId + "]";
	}
	
	
}
