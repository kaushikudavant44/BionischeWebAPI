package com.bionische.biotech.blooddonation.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lab_details")
public class DonorRegDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="donor_id")
	private int donorId;
	
	@Column(name="donor_cityid")
private int donorCityId;
	
	@Column(name="donor_city")
private String donorCity;
	
	@Column(name="donor_name")
private String donorName;
	
	@Column(name="donor_birthdate")
private int donorBirthDate;
	
	@Column(name="donor_age")
private int donorAge;
	
	@Column(name="dono_bloodgroup")
private String donorBloodGroup;
	
	@Column(name="occupation")
private String Occupation;
	
	@Column(name="donorsex")
private String donorSex;
	
	@Column(name="address")
private String address;
	
	@Column(name="pincode")
private int pincode;
	
	@Column(name="donorcontact_1")
private String donorContact1;
	
	@Column(name="donorcontact_2")
private String donorContact2;
	
	@Column(name="other")
private String other;
	
	@Column(name="string1")
private String string1;
	
	@Column(name="string2")
private String string2;
	
	@Column(name="int_1")
private int int1;
	
	@Column(name="int_2")
private int int2;
	
	@Column(name="del_status")
private int delStatus;
	
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public int getDonorCityId() {
		return donorCityId;
	}
	public void setDonorCityId(int donorCityId) {
		this.donorCityId = donorCityId;
	} 
	public String getDonorCity() {
		return donorCity;
	}
	public void setDonorCity(String donorCity) {
		this.donorCity = donorCity;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public int getDonorBirthDate() {
		return donorBirthDate;
	}
	public void setDonorBirthDate(int donorBirthDate) {
		this.donorBirthDate = donorBirthDate;
	}
	public int getDonorAge() {
		return donorAge;
	}
	public void setDonorAge(int donorAge) {
		this.donorAge = donorAge;
	}
	public String getDonorBloodGroup() {
		return donorBloodGroup;
	}
	public void setDonorBloodGroup(String donorBloodGroup) {
		this.donorBloodGroup = donorBloodGroup;
	}
	public String getOccupation() {
		return Occupation;
	}
	public void setOccupation(String occupation) {
		Occupation = occupation;
	}
	public String getDonorSex() {
		return donorSex;
	}
	public void setDonorSex(String donorSex) {
		this.donorSex = donorSex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getDonorContact1() {
		return donorContact1;
	}
	public void setDonorContact1(String donorContact1) {
		this.donorContact1 = donorContact1;
	}
	public String getDonorContact2() {
		return donorContact2;
	}
	public void setDonorContact2(String donorContact2) {
		this.donorContact2 = donorContact2;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getString1() {
		return string1;
	}
	public void setString1(String string1) {
		this.string1 = string1;
	}
	public String getString2() {
		return string2;
	}
	public void setString2(String string2) {
		this.string2 = string2;
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
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	@Override
	public String toString() {
		return "DonorRegDetails [donorId=" + donorId + ", donorCityId=" + donorCityId + ", donorCity=" + donorCity
				+ ", donorName=" + donorName + ", donorBirthDate=" + donorBirthDate + ", donorAge=" + donorAge
				+ ", donorBloodGroup=" + donorBloodGroup + ", Occupation=" + Occupation + ", donorSex=" + donorSex
				+ ", address=" + address + ", pincode=" + pincode + ", donorContact1=" + donorContact1
				+ ", donorContact2=" + donorContact2 + ", other=" + other + ", string1=" + string1 + ", string2="
				+ string2 + ", int1=" + int1 + ", int2=" + int2 + ", delStatus=" + delStatus + "]";
	}
	

	
	

}
