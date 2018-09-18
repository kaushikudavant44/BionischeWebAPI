package com.bionische.biotech.model;

public class MedicalLogin {

	
	MedicalDetails medicalDetails;
	Info info;
	public MedicalDetails getMedicalDetails() {
		return medicalDetails;
	}
	public void setMedicalDetails(MedicalDetails medicalDetails) {
		this.medicalDetails = medicalDetails;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "MedicalLogin [medicalDetails=" + medicalDetails + ", info=" + info + "]";
	}
	
	
	
	
	
}
