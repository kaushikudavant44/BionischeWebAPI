package com.bionische.biotech.history.model;

import java.util.List;

import com.bionische.biotech.model.Info;

public class PatientSystemDetailsList {

	
	List<PatientSystemDetails> patientSystemDetailsList;
	List<PatientSystemHeader> patientSystemHeaderList;
	Info info;
	public List<PatientSystemDetails> getPatientSystemDetailsList() {
		return patientSystemDetailsList;
	}
	public void setPatientSystemDetailsList(List<PatientSystemDetails> patientSystemDetailsList) {
		this.patientSystemDetailsList = patientSystemDetailsList;
	}
	public List<PatientSystemHeader> getPatientSystemHeaderList() {
		return patientSystemHeaderList;
	}
	public void setPatientSystemHeaderList(List<PatientSystemHeader> patientSystemHeaderList) {
		this.patientSystemHeaderList = patientSystemHeaderList;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "PatientSystemDetailsList [patientSystemDetailsList=" + patientSystemDetailsList
				+ ", patientSystemHeaderList=" + patientSystemHeaderList + ", info=" + info + "]";
	}
	 
	
}
