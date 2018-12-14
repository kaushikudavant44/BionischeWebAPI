package com.bionische.biotech.model;

public class PatientLogin {

	
	
	PatientDetails patientDetails;
	
	Info info;
	Info suscriptionInfo;

	public PatientDetails getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	public Info getSuscriptionInfo() {
		return suscriptionInfo;
	}

	public void setSuscriptionInfo(Info suscriptionInfo) {
		this.suscriptionInfo = suscriptionInfo;
	}

	@Override
	public String toString() {
		return "PatientLogin [patientDetails=" + patientDetails + ", info=" + info + ", suscriptionInfo="
				+ suscriptionInfo + "]";
	}

	 
	
	
}
