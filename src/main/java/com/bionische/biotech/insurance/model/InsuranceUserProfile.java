package com.bionische.biotech.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="patient_insurance")
public class InsuranceUserProfile {

	




	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="patient_profile_id")
	private int patientProfileId;
	
	public int getPatientProfileId() {
		return patientProfileId;
	}
	public void setPatientProfileId(int patientProfileId) {
		this.patientProfileId = patientProfileId;
	}

	@Column(name="dob")
	private String dob;
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	@Column(name="full_name")
	private String fullName;
	@Column(name="email")
	private String email;
	
	@Column(name="city")
	private String city;
	@Column(name="mobile_No")
	private int mobileno;
	@Column(name="gender")
	private String gender;
	@Column(name="poliicy_cover")
	private String policyCover;
	@Column(name="amount_covor")
	private int amountCovor;
	@Column(name="anual_income")
	private int anualIncome;
	@Column(name="del_status")
	private int delStatus;
	@Column(name="int_1")
	private int int1;
	@Column(name="int_2")
	private int int2;
	@Column(name="int_3")
	private int int3;
	@Column(name="string1")
	private String string1;
	@Column(name="string2")
	private String string2;
	@Column(name="string3")
	private String string3;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getMobileno() {
		return mobileno;
	}
	public void setMobileno(int mobileno) {
		this.mobileno = mobileno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPolicyCover() {
		return policyCover;
	}
	public void setPolicyCover(String policyCover) {
		this.policyCover = policyCover;
	}
	public int getAmountCovor() {
		return amountCovor;
	}
	public void setAmountCovor(int amountCovor) {
		this.amountCovor = amountCovor;
	}
	public int getAnualIncome() {
		return anualIncome;
	}
	public void setAnualIncome(int anualIncome) {
		this.anualIncome = anualIncome;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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
	public int getInt3() {
		return int3;
	}
	public void setInt3(int int3) {
		this.int3 = int3;
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
	public String getString3() {
		return string3;
	}
	public void setString3(String string3) {
		this.string3 = string3;
	}
	@Override
	public String toString() {
		return "PatientProfile [patientprofileid=" + patientProfileId + ", dob=" + dob + ", fullName=" + fullName
				+ ", email=" + email + ", city=" + city + ", mobileno=" + mobileno + ", gender=" + gender
				+ ", policyCover=" + policyCover + ", amountCovor=" + amountCovor + ", anualIncome=" + anualIncome
				+ ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2 + ", int3=" + int3 + ", string1="
				+ string1 + ", string2=" + string2 + ", string3=" + string3 + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
