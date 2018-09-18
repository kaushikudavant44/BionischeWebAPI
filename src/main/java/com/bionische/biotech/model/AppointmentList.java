package com.bionische.biotech.model;

import java.util.List;

public class AppointmentList {

	private List<AppointmentDetails> appointmentDetailsList;

	Info info;

	public List<AppointmentDetails> getAppointmentDetailsList() {
		return appointmentDetailsList;
	}

	public void setAppointmentDetailsList(List<AppointmentDetails> appointmentDetailsList) {
		this.appointmentDetailsList = appointmentDetailsList;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "AppointmentList [appointmentDetailsList=" + appointmentDetailsList + ", info=" + info + "]";
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
