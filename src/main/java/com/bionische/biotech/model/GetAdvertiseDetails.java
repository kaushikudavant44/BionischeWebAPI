package com.bionische.biotech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class GetAdvertiseDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adsId;
	
	private int adsType;
	
	private String fileName;
	
	private String fromName;
	
	private int adsFrom;
	
	private int fromType; 
	
	private String expDate;
 
	private int delStatus;

	public int getAdsId() {
		return adsId;
	}

	public void setAdsId(int adsId) {
		this.adsId = adsId;
	}

	public int getAdsType() {
		return adsType;
	}

	public void setAdsType(int adsType) {
		this.adsType = adsType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getAdsFrom() {
		return adsFrom;
	}

	public void setAdsFrom(int adsFrom) {
		this.adsFrom = adsFrom;
	}

	public int getFromType() {
		return fromType;
	}

	public void setFromType(int fromType) {
		this.fromType = fromType;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	@Override
	public String toString() {
		return "GetAdvertiseDetails [adsId=" + adsId + ", adsType=" + adsType + ", fileName=" + fileName + ", fromName="
				+ fromName + ", adsFrom=" + adsFrom + ", fromType=" + fromType + ", expDate=" + expDate + ", delStatus="
				+ delStatus + "]";
	}

	 
}
