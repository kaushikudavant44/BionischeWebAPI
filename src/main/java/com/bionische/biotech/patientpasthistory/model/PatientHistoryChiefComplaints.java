package com.bionische.biotech.patientpasthistory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_history_chief_complaints")

public class PatientHistoryChiefComplaints {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="chief_complaints")
	private int chiefcomplaintsId;
	@Column(name="patient_id")
	private int patientId;
	@Column(name="complaints",nullable = true)
	private String complaints;
	public int getChiefcomplaintsId() {
		return chiefcomplaintsId;
	}
	public void setChiefcomplaintsId(int chiefcomplaintsId) {
		this.chiefcomplaintsId = chiefcomplaintsId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getComplaints() {
		return complaints;
	}
	public void setComplaints(String complaints) {
		this.complaints = complaints;
	}
	@Override
	public String toString() {
		return "PatientHistoryChiefComplaints [chiefcomplaintsId=" + chiefcomplaintsId + ", patientId=" + patientId
				+ ", complaints=" + complaints + "]";
	}
	 
}
