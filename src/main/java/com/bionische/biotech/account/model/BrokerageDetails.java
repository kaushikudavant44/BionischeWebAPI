package com.bionische.biotech.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;


@Entity
@Table(name="m_brokerage_details")
public class BrokerageDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="doctor_per")
	private float doctorPer;
	
	@Column(name="pharmacy_per")
	private float pharmacyPer;
	
	@Column(name="lab_per")
	private float labPer;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="del_status")
	private int delStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getDoctorPer() {
		return doctorPer;
	}

	public void setDoctorPer(float doctorPer) {
		this.doctorPer = doctorPer;
	}

	public float getPharmacyPer() {
		return pharmacyPer;
	}

	public void setPharmacyPer(float pharmacyPer) {
		this.pharmacyPer = pharmacyPer;
	}

	public float getLabPer() {
		return labPer;
	}

	public void setLabPer(float labPer) {
		this.labPer = labPer;
	}

	public String getCreatedDate() {
		return DateConverter.convertToDMY(createdDate);
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "BrokerageDetails [id=" + id + ", doctorPer=" + doctorPer + ", pharmacyPer=" + pharmacyPer + ", labPer="
				+ labPer + ", createdDate=" + createdDate + ", delStatus=" + delStatus + "]";
	}
	
	
}
