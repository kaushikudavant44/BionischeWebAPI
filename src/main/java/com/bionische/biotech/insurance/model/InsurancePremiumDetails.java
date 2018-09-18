package com.bionische.biotech.insurance.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_premium")

public class InsurancePremiumDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="insurancepremium_id")
	private int insurancePremiumId;
	
	@Column(name="first_name")
private String firstName;
	
	@Column(name="middle_name")
private String middleName;
	
	@Column(name="last_name")
private String lastName;
	
	@Column(name="marital_status")
private String maritalStatus;
	
	@Column(name="birth_date")
private String birthDate;
	
	@Column(name="occupation")
 private String occupation;
	
	@Column(name="nationality")
 private String nationality;
	
	@Column(name="education")
private String educationalQualification;
	
	@Column(name="policyterm")
private String policyTerm;
	
	@Column(name="premium")
private int premium;
	
	@Column(name="height")
 private float height;
	
	@Column(name="weight")
private int  weight;
	
	@Column(name="nominee_relation")
private String nomineeRelation;
	
	@Column(name="nominee_firstname")
private String nomineefName;  
	
	@Column(name="nominee_lastname")
 private String nomineelName;
	
	@Column(name="nominee_middlename")
 private String nomineemName;
	
	@Column(name="nominee_bithdate")
 private String nomineebirthDate;
	
	@Column(name="nominee_address")
 private String nomineeAddress;
	
	@Column(name="nominee_contact")
private String nomineeContact;
	
	@Column(name="mobile_no")
 private String mobile;

	@Column(name="address1")
 private String address1;
	
	@Column(name="address2")
private String address2;
	
	@Column(name="landmark")
private String landMark;
	
	@Column(name="state")
private String state;
	
	@Column(name="city")
 private String city;
	
	@Column(name="pincode")
private int pincode;
	
	@Column(name="email_id")
private String emailId;
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;
	
	@Column(name="string1")
	private int string1;
	
	@Column(name="string2")
	private int string2;
	
	@Column(name="del_status")
	private int delStatus;


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
	public int getString1() {
		return string1;
	}
	public void setString1(int string1) {
		this.string1 = string1;
	}
	public int getString2() {
		return string2;
	}
	public void setString2(int string2) {
		this.string2 = string2;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public int getInsurancePremiumId() {
		return insurancePremiumId;
	}
	public void setInsurancePremiumId(int insurancePremiumId) {
		this.insurancePremiumId = insurancePremiumId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getEducationalQualification() {
		return educationalQualification;
	}
	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}
	public String getPolicyTerm() {
		return policyTerm;
	}
	public void setPolicyTerm(String policyTerm) {
		this.policyTerm = policyTerm;
	}
	public int getPremium() {
		return premium;
	}
	public void setPremium(int premium) {
		this.premium = premium;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getNomineeRelation() {
		return nomineeRelation;
	}
	public void setNomineeRelation(String nomineeRelation) {
		this.nomineeRelation = nomineeRelation;
	}
	public String getNomineefName() {
		return nomineefName;
	}
	public void setNomineefName(String nomineefName) {
		this.nomineefName = nomineefName;
	}
	public String getNomineelName() {
		return nomineelName;
	}
	public void setNomineelName(String nomineelName) {
		this.nomineelName = nomineelName;
	}
	public String getNomineemName() {
		return nomineemName;
	}
	public void setNomineemName(String nomineemName) {
		this.nomineemName = nomineemName;
	}
	public String getNomineebirthDate() {
		return nomineebirthDate;
	}
	public void setNomineebirthDate(String nomineebirthDate) {
		this.nomineebirthDate = nomineebirthDate;
	}
	public String getNomineeAddress() {
		return nomineeAddress;
	}
	public void setNomineeAddress(String nomineeAddress) {
		this.nomineeAddress = nomineeAddress;
	}
	public String getNomineeContact() {
		return nomineeContact;
	}
	public void setNomineeContact(String nomineeContact) {
		this.nomineeContact = nomineeContact;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "InsurancePremiumDetails [insurancePremiumId=" + insurancePremiumId + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", maritalStatus=" + maritalStatus
				+ ", birthDate=" + birthDate + ", occupation=" + occupation + ", nationality=" + nationality
				+ ", educationalQualification=" + educationalQualification + ", policyTerm=" + policyTerm + ", premium="
				+ premium + ", height=" + height + ", weight=" + weight + ", nomineeRelation=" + nomineeRelation
				+ ", nomineefName=" + nomineefName + ", nomineelName=" + nomineelName + ", nomineemName=" + nomineemName
				+ ", nomineebirthDate=" + nomineebirthDate + ", nomineeAddress=" + nomineeAddress + ", nomineeContact="
				+ nomineeContact + ", mobile=" + mobile + ", address1=" + address1 + ", address2=" + address2
				+ ", landMark=" + landMark + ", state=" + state + ", city=" + city + ", pincode=" + pincode
				+ ", emailId=" + emailId + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2="
				+ string2 + ", delStatus=" + delStatus + "]";
	}
	
	     }