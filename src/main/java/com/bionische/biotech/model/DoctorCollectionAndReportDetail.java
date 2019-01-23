package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorCollectionAndReportDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="unread_report")
	private int unreadReport;
	
	@Column(name="total_collection")
	private int totalCollection;

	public int getUnreadReport() {
		return unreadReport;
	}

	public void setUnreadReport(int unreadReport) {
		this.unreadReport = unreadReport;
	}

	public int getTotalCollection() {
		return totalCollection;
	}

	public void setTotalCollection(int totalCollection) {
		this.totalCollection = totalCollection;
	}

	@Override
	public String toString() {
		return "DoctorCollectionAndReportDetail [unreadReport=" + unreadReport + ", totalCollection=" + totalCollection
				+ "]";
	}
	
	
}
