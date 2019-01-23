package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorAppointmentCount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="total_app")
	private int totalApp;
	
	@Column(name="completed_app")
	private int completedApp;

	public int getTotalApp() {
		return totalApp;
	}

	public void setTotalApp(int totalApp) {
		this.totalApp = totalApp;
	}

	public int getCompletedApp() {
		return completedApp;
	}

	public void setCompletedApp(int completedApp) {
		this.completedApp = completedApp;
	}

	@Override
	public String toString() {
		return "DoctorAppointmentCount [totalApp=" + totalApp + ", completedApp=" + completedApp + "]";
	}
	

}
