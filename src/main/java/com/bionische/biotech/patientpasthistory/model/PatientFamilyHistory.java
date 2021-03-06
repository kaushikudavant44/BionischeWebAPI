package com.bionische.biotech.patientpasthistory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_family_history")

public class PatientFamilyHistory {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="famity_history_id")
	private int familyHistoryId;
	@Column(name="patient_id")
	private int patientId;
	@Column(name="family_history",nullable = true)
	private String familyHistory;
	@Column(name="string1",nullable = true)
	private String string1;
	@Column(name="string2",nullable = true)
	private String string2;
	
	public int getFamilyHistoryId() {
		return familyHistoryId;
	}
	public void setFamilyHistoryId(int familyHistoryId) {
		this.familyHistoryId = familyHistoryId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFamilyHistory() {
		return familyHistory;
	}
	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
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
	@Override
	public String toString() {
		return "PatientFamilyHistory [familyHistoryId=" + familyHistoryId + ", patientId=" + patientId
				+ ", familyHistory=" + familyHistory + ", string1=" + string1 + ", string2=" + string2 + "]";
	}
	
	
	
	
}
