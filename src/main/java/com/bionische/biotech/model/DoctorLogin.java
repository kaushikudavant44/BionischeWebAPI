package com.bionische.biotech.model;

public class DoctorLogin {

	DoctorDetails doctorDetails;
	Info info;
	public DoctorDetails getDoctorDetails() {
		return doctorDetails;
	}
	public void setDoctorDetails(DoctorDetails doctorDetails) {
		this.doctorDetails = doctorDetails;
	}
	public Info getInfo() {
		return info;
	}
	public void setInfo(Info info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "DoctorLogin [doctorDetails=" + doctorDetails + ", info=" + info + "]";
	}
	
}
