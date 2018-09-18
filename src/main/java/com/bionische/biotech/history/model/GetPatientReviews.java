package com.bionische.biotech.history.model;

import java.util.List;

import com.bionische.biotech.model.Info;

public class GetPatientReviews {
	private int patientId;
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public List<PatientSystemDetails> getPatientSystemDetailsList() {
		return PatientSystemDetailsList;
	}

	public void setPatientSystemDetailsList(List<PatientSystemDetails> patientSystemDetailsList) {
		PatientSystemDetailsList = patientSystemDetailsList;
	}

	public List<PatientSystemHeader> getPatientSystemHeaderList() {
		return PatientSystemHeaderList;
	}

	public void setPatientSystemHeaderList(List<PatientSystemHeader> patientSystemHeaderList) {
		PatientSystemHeaderList = patientSystemHeaderList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	private String patientName;
	  List<PatientSystemDetails> PatientSystemDetailsList;
	  List<PatientSystemHeader> PatientSystemHeaderList;

	Info info;
	@Override
	public String toString() {
		return "GetPatientReviews [patientId=" + patientId + ", patientName=" + patientName
				+ ", PatientSystemDetailsList=" + PatientSystemDetailsList + ", PatientSystemHeaderList="
				+ PatientSystemHeaderList + ", info=" + info + "]";
	}
	
}
