package com.bionische.biotech.patientpasthistory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_psychological_history")

public class PatientPsychologicalHistory {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="psychological_history_id")
	private int psychologicaLHistoryId;
	@Column(name="patient_id")
	private int patientId;
	@Column(name="psychological_history",nullable = true)
	private String psychologicalHistory;
	@Column(name="string1",nullable = true)
	private String string1;
	@Column(name="string2",nullable = true)
	private String string2;
	
	public int getPsychologicaLHistoryId() {
		return psychologicaLHistoryId;
	}
	public void setPsychologicaLHistoryId(int psychologicaLHistoryId) {
		this.psychologicaLHistoryId = psychologicaLHistoryId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPsychologicalHistory() {
		return psychologicalHistory;
	}
	public void setPsychologicalHistory(String psychologicalHistory) {
		this.psychologicalHistory = psychologicalHistory;
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
		return "PatientPsychologicalHistory [psychologicaLHistoryId=" + psychologicaLHistoryId + ", patientId="
				+ patientId + ", psychologicalHistory=" + psychologicalHistory + ", string1=" + string1 + ", string2="
				+ string2 + "]";
	}
	
	
	
}

