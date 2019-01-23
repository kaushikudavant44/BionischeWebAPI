package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorAppOfLastThirtyDays {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="app_date")
	private int appDate;
	
	@Column(name="total_app")
	private int totalApp;

	public int getAppDate() {
		return appDate;
	}

	public void setAppDate(int appDate) {
		this.appDate = appDate;
	}

	public int getTotalApp() {
		return totalApp;
	}

	public void setTotalApp(int totalApp) {
		this.totalApp = totalApp;
	}

	@Override
	public String toString() {
		return "DoctorAppOfLastThirtyDays [appDate=" + appDate + ", totalApp=" + totalApp + "]";
	}
	
	 

}
