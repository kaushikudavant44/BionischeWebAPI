package com.bionische.biotech.blooddonation.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bloodbankreg_details")

public class BloodBankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="bloodbank_id")
private int bloodBankId;
	
	@Column(name="bloodbank_name")
private String bloodBankName;
	
	@Column(name="bloodbank_city")
private String bloodBankCity;
	
	@Column(name="bloodbank_cityid")
private int bloodBankCityId;
	
	@Column(name="bloodbank_contact")
private int bloodBankContact;
	
	@Column(name="bloodbank_emailid")
private String bloodBankEmailId;
	
	@Column(name="bloodbank_address")
private String bloodBankAddress;
	
	@Column(name="bloodbank_country")
private String bloodBankCountry;
	
	@Column(name="bloodbank_state")
private String bloodBankState;
	
	@Column(name="locality")
private String Locality;
	
	@Column(name="type")
private int type;
	
	@Column(name="int_1")
private int int1;
	
	@Column(name="int_2")
private int int2;
	
	@Column(name="string1")
private String String1;
	
	@Column(name="string2")
private String String2;
	
	@Column(name="del_status")
private int delstatus;
	
	@Column(name="image")
private String image;
	
public int getBloodBankId() {
	return bloodBankId;
}
public void setBloodBankId(int bloodBankId) {
	this.bloodBankId = bloodBankId;
}
public String getBloodBankName() {
	return bloodBankName;
}
public void setBloodBankName(String bloodBankName) {
	this.bloodBankName = bloodBankName;
}
public String getBloodBankCity() {
	return bloodBankCity;
}
public void setBloodBankCity(String bloodBankCity) {
	this.bloodBankCity = bloodBankCity;
}
public int getBloodBankCityId() {
	return bloodBankCityId;
}
public void setBloodBankCityId(int bloodBankCityId) {
	this.bloodBankCityId = bloodBankCityId;
}
public int getBloodBankContact() {
	return bloodBankContact;
}
public void setBloodBankContact(int bloodBankContact) {
	this.bloodBankContact = bloodBankContact;
}
public String getBloodBankEmailId() {
	return bloodBankEmailId;
}
public void setBloodBankEmailId(String bloodBankEmailId) {
	this.bloodBankEmailId = bloodBankEmailId;
}
public String getBloodBankAddress() {
	return bloodBankAddress;
}
public void setBloodBankAddress(String bloodBankAddress) {
	this.bloodBankAddress = bloodBankAddress;
}
public String getBloodBankCountry() {
	return bloodBankCountry;
}
public void setBloodBankCountry(String bloodBankCountry) {
	this.bloodBankCountry = bloodBankCountry;
}
public String getBloodBankState() {
	return bloodBankState;
}
public void setBloodBankState(String bloodBankState) {
	this.bloodBankState = bloodBankState;
}
public String getLocality() {
	return Locality;
}
public void setLocality(String locality) {
	Locality = locality;
}
public int getType() {
	return type;
}
public void setType(int type) {
	this.type = type;
}
public int getInt1() {
	return int1;
}
public void setInt1(int int1) {
	this.int1 = int1;
}
public int getInt2() {
	return int2;
}
public void setInt2(int int2) {
	this.int2 = int2;
}
public String getString1() {
	return String1;
}
public void setString1(String string1) {
	String1 = string1;
}
public String getString2() {
	return String2;
}
public void setString2(String string2) {
	String2 = string2;
}
public int getDelstatus() {
	return delstatus;
}
public void setDelstatus(int delstatus) {
	this.delstatus = delstatus;
}

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
@Override
public String toString() {
	return "BloodBankRegDetails [bloodBankId=" + bloodBankId + ", bloodBankName=" + bloodBankName + ", bloodBankCity="
			+ bloodBankCity + ", bloodBankCityId=" + bloodBankCityId + ", bloodBankContact=" + bloodBankContact
			+ ", bloodBankEmailId=" + bloodBankEmailId + ", bloodBankAddress=" + bloodBankAddress
			+ ", bloodBankCountry=" + bloodBankCountry + ", bloodBankState=" + bloodBankState + ", Locality=" + Locality
			+ ", type=" + type + ", int1=" + int1 + ", int2=" + int2 + ", String1=" + String1 + ", String2=" + String2
			+ ", delstatus=" + delstatus + ", image=" + image + "]";
}




}
