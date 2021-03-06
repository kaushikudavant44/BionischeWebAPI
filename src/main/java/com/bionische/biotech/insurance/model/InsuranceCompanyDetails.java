package com.bionische.biotech.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="insurance_company")
public class InsuranceCompanyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="insurance_company_id")
	private int insuranceCompanyId;
	@Column(name="insurance_company_name")
	private String insuranceCompanyName;
	@Column(name="photo")
	private String photo;
	@Column(name="country")
	private String country;
	@Column(name="company_about")
	private String companyAbout;
	@Column(name="headquater_address")
	private String headquaterAddress;
	@Column(name="contact_1")
	private int contact1;
	@Column(name="contact_2")
	private int contact2;
	@Column(name="email_1")
	private String email1;
	@Column(name="email_2")
	private String email2;
	@Column(name="website_link")
	private String websiteLink;
	@Column(name="slogan")
	private String slogan;
	@Column(name="delstatus")
	private int delStatus;
	@Column(name="string1")
	private String string1;
	@Column(name="string2")
	private String string2;
	@Column(name="int_1")
	private int int1;
	@Column(name="int_2")
	private int int2;
	@Column(name="float_1")
	private float float1;
	@Column(name="float_2")
	private float float2;
	
	public int getInsuranceCompanyid() {
		return insuranceCompanyId;
	}
	public void setInsuranceCompanyid(int insuranceCompanyid) {
		this.insuranceCompanyId = insuranceCompanyid;
	}
	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}
	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCompanyAbout() {
		return companyAbout;
	}
	public void setCompanyAbout(String companyAbout) {
		this.companyAbout = companyAbout;
	}
	public String getHeadquaterAddress() {
		return headquaterAddress;
	}
	public void setHeadquaterAddress(String headquaterAddress) {
		this.headquaterAddress = headquaterAddress;
	}
	public int getContact1() {
		return contact1;
	}
	public void setContact1(int contact1) {
		this.contact1 = contact1;
	}
	public int getContact2() {
		return contact2;
	}
	public void setContact2(int contact2) {
		this.contact2 = contact2;
	}
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}
	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}
	public String getWebsiteLink() {
		return websiteLink;
	}
	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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
	public float getFloat1() {
		return float1;
	}
	public void setFloat1(float float1) {
		this.float1 = float1;
	}
	public float getFloat2() {
		return float2;
	}
	public void setFloat2(float float2) {
		this.float2 = float2;
	}
	@Override
	public String toString() {
		return "InsuranceCompanyDetails [insuranceCompanyId=" + insuranceCompanyId + ", insuranceCompanyName="
				+ insuranceCompanyName + ", photo=" + photo + ", country=" + country + ", companyAbout=" + companyAbout
				+ ", headquaterAddress=" + headquaterAddress + ", contact1=" + contact1 + ", contact2=" + contact2
				+ ", email1=" + email1 + ", email2=" + email2 + ", websiteLink=" + websiteLink + ", slogan=" + slogan
				+ ", delStatus=" + delStatus + ", string1=" + string1 + ", string2=" + string2 + ", int1=" + int1
				+ ", int2=" + int2 + ", float1=" + float1 + ", float2=" + float2 + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
