package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity


public class GetStemcellBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="stemcell_id")
	private int stemCellId;
	@Column(name="stemcell_name")
    private String stemCellName;
	
	
	
	@Column(name="city_id")
private int cityId;
	
	@Column(name="address")
private String stemCellAddress;
	
	@Column(name="contact1")
private String contact1;
	


	
	@Column(name="email_id")
private String emailId;
	

	
	
	
	@Column(name="rating")
	private float rating;





	public int getStemCellId() {
		return stemCellId;
	}





	public void setStemCellId(int stemCellId) {
		this.stemCellId = stemCellId;
	}





	public String getStemCellName() {
		return stemCellName;
	}





	public void setStemCellName(String stemCellName) {
		this.stemCellName = stemCellName;
	}





	public int getCityId() {
		return cityId;
	}





	public void setCityId(int cityId) {
		this.cityId = cityId;
	}





	public String getStemCellAddress() {
		return stemCellAddress;
	}





	public void setStemCellAddress(String stemCellAddress) {
		this.stemCellAddress = stemCellAddress;
	}





	public String getContact1() {
		return contact1;
	}





	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}





	public String getEmailId() {
		return emailId;
	}





	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}





	public float getRating() {
		return rating;
	}





	public void setRating(float rating) {
		this.rating = rating;
	}





	@Override
	public String toString() {
		return "GetStemcellBankDetails [stemCellId=" + stemCellId + ", stemCellBankName=" + stemCellName
				+ ", cityId=" + cityId + ", stemCellAddress=" + stemCellAddress + ", contact1=" + contact1
				+ ", emailId=" + emailId + ", rating=" + rating + "]";
	}

	
}
