package com.bionische.biotech.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MakePayment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="insu_reg_id")
	private int appId;
	
	@Column(name="Insurance_company_name")
	private String companyName;
	
	@Column(name="insu_cover")
	private int cover;
	
	@Column(name="insu_premium")
	private int premium;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getCover() {
		return cover;
	}

	public void setCover(int cover) {
		this.cover = cover;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	@Override
	public String toString() {
		return "MakePayment [appId=" + appId + ", companyName=" + companyName + ", cover=" + cover + ", premium="
				+ premium + "]";
	}
	
	
	
	
	
	

}
