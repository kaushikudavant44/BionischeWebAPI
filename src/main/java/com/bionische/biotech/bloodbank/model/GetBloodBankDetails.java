package com.bionische.biotech.bloodbank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetBloodBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	@Column(name="bloodbank_id")
	private int bloodBankId;
	
	@Column(name="bloodbank_name")
    private String bloodBankName;    

	@Column(name="date")
    private String date;    
	
	@Column(name="image")
    private String image;    
	
	
	@Column(name="blood_group")
    private String bloodGroup;   
	

	@Column(name="location")
    private String location;   
	
	@Column(name="bloodbank_cityid")
	private int cityId;
	
	@Column(name="bloodbank_address")
    private String bloodBankAddress;
	
	
	@Column(name="bloodbank_contact")
	private String bloodBankContact;
		
	
	@Column(name="bloodbank_emailid")
	private String bloodBankEmailId;
	
	@Column(name="rating")
	private float rating;


	public int getBloodBankId() {
		return bloodBankId;
	}


	public void setBloodBankId(int bloodBankId) {
		this.bloodBankId = bloodBankId;
	}


	public float getRating() {
		return rating;
	}


	public void setRating(float rating) {
		this.rating = rating;
	}


	public String getBloodBankName() {
		return bloodBankName;
	}


	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName = bloodBankName;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public int getCityId() {
		return cityId;
	}


	public void setCityId(int cityId) {
		this.cityId = cityId;
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


	@Override
	public String toString() {
		return "GetBloodBankDetails [bloodBankId=" + bloodBankId + ", bloodBankName=" + bloodBankName + ", date=" + date
				+ ", image=" + image + ", bloodGroup=" + bloodGroup + ", location=" + location + ", cityId=" + cityId
				+ ", bloodBankAddress=" + bloodBankAddress + ", bloodBankContact=" + bloodBankContact
				+ ", bloodBankEmailId=" + bloodBankEmailId + ", rating=" + rating + "]";
	}


	

	
	     
	

	



	



	




	


	

	
}
