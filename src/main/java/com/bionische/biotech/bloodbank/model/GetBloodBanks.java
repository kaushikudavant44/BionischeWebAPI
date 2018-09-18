package com.bionische.biotech.bloodbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity


public class GetBloodBanks {

	@Id   
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bloodbank_id")
	private int bloodbankId;
	@Column(name="bloodbank_name")
    private String bloodbankName;
	     
	
	
	@Column(name="bloodbank_cityid")
private int bloodBankCityId;
	
	@Column(name="bloodbank_address")
	private String bloodBankAddress;
		
	@Column(name="bloodbank_contact")
	private String bloodBankContact;
		
	

	@Column(name="bloodbank_emailid")
	private String bloodBankEmailId;
		

	
	
	
	@Column(name="rating")
	private float rating;





	public int getBloodbankId() {
		return bloodbankId;
	}





	public void setBloodbankId(int bloodbankId) {
		this.bloodbankId = bloodbankId;
	}





	public String getBloodbankName() {
		return bloodbankName;
	}





	public void setBloodbankName(String bloodbankName) {
		this.bloodbankName = bloodbankName;
	}





	public int getBloodBankCityId() {
		return bloodBankCityId;
	}





	public void setBloodBankCityId(int bloodBankCityId) {
		this.bloodBankCityId = bloodBankCityId;
	}





	public String getBloodBankAddress() {
		return bloodBankAddress;
	}





	public void setBloodBankAddress(String bloodBankAddress) {
		this.bloodBankAddress = bloodBankAddress;
	}





	public String getBloodBankContact() {
		return bloodBankContact;
	}





	public void setBloodBankContact(String bloodBankContact) {
		this.bloodBankContact = bloodBankContact;
	}





	public String getBloodBankEmailId() {
		return bloodBankEmailId;
	}





	public void setBloodBankEmailId(String bloodBankEmailId) {
		this.bloodBankEmailId = bloodBankEmailId;
	}





	public float getRating() {
		return rating;
	}





	public void setRating(float rating) {
		this.rating = rating;
	}





	@Override
	public String toString() {
		return "GetBloodBanks [bloodbankId=" + bloodbankId + ", bloodbankName=" + bloodbankName + ", bloodBankCityId="
				+ bloodBankCityId + ", bloodBankAddress=" + bloodBankAddress + ", bloodBankContact=" + bloodBankContact
				+ ", bloodBankEmailId=" + bloodBankEmailId + ", rating=" + rating + "]";
	}





	
}
