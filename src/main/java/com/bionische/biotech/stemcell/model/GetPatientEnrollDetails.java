package com.bionische.biotech.stemcell.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class GetPatientEnrollDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	@Column(name="patientenroll_id")
	private int patientenrollId;
	
	            
	@Column(name="time")
	private String time;
	
 
	
 
	    
	@Column(name="plan_id")
	private String planId;
	
	
	 

	@Column(name="date")
	private String date;
	
	
	
	@Column(name="plan_type")
	private String planType;
	
	@Column(name="plan_name")
	private String planName;
	
	
	@Column(name="plan_cost")
	private String planCost;
	
	@Column(name="plan_days")
	private String planDays;
		
    @Column(name="delivery_date")
	private String expectedDeliveryDate;

	public int getPatientenrollId() {
		return patientenrollId;
	}

	public void setPatientenrollId(int patientenrollId) {
		this.patientenrollId = patientenrollId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlanId() {
		return planId;
	}

	public void setPlanId(String planId) {
		this.planId = planId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanCost() {
		return planCost;
	}

	public void setPlanCost(String planCost) {
		this.planCost = planCost;
	}

	public String getPlanDays() {
		return planDays;
	}

	public void setPlanDays(String planDays) {
		this.planDays = planDays;
	}

	public String getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}

	public void setExpectedDeliveryDate(String expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
	}

	@Override
	public String toString() {
		return "GetPatientEnrollDetails [patientenrollId=" + patientenrollId + ", time=" + time + ", planId=" + planId
				+ ", date=" + date + ", planType=" + planType + ", planName=" + planName + ", planCost=" + planCost
				+ ", planDays=" + planDays + ", expectedDeliveryDate=" + expectedDeliveryDate + "]";
	}

	
	

	 

	
	}

	
	
	

	