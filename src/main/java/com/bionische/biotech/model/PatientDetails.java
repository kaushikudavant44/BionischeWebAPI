package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_details")
public class PatientDetails {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="family_id")
	private int familyId;
	
	@Column(name="uname",nullable=true)
	private String userName;
	
	@Column(name="password",nullable=true)
	private String password;  
	  
	@Column(name="f_name")
	private String fName;
	
	@Column(name="l_name")
	private String lName;
	
	@Column(name="m_name")
	private String mName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="address")
	private String address;
	
	@Column(name="contact")
	private String contactNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="blood_group")
	private String bloodGroup;
	
	@Column(name="reg_date")
	private String regDate;
	 
	@Column(name="city_id")
	private int cityId;
	 
	@Column(name="birth_date")
	private String birthDate;
 
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="age")
	private int age;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;
	
	@Column(name="string1")
	private String string1;
	
	@Column(name="string2")
	private String string2;
	
	@Column(name="state_id")
	private int stateId;
	
	@Column(name="qualification")
    private String qualification;
	
	@Column(name="profile_photo")
    private String profilePhoto;
	
	@Column(name="country_id")
	private int countryId;
	
	@Column(name="refferal_code")
	private String refferalCode;

	@Column(name="web_token")
	private String webToken;
	
	@Column(name="mother_name")
	private String motherName;
	
	public String getRefferalCode() {
		return refferalCode;
	}

	public void setRefferalCode(String refferalCode) {
		this.refferalCode = refferalCode;
	}

	public int getPatientId() {
		return patientId;
	}
	
	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}



	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getWebToken() {
		return webToken;
	}

	public void setWebToken(String webToken) {
		this.webToken = webToken;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	@Override
	public String toString() {
		return "PatientDetails [patientId=" + patientId + ", familyId=" + familyId + ", userName=" + userName
				+ ", password=" + password + ", fName=" + fName + ", lName=" + lName + ", mName=" + mName + ", gender="
				+ gender + ", address=" + address + ", contactNo=" + contactNo + ", email=" + email + ", bloodGroup="
				+ bloodGroup + ", regDate=" + regDate + ", cityId=" + cityId + ", birthDate=" + birthDate
				+ ", delStatus=" + delStatus + ", age=" + age + ", int1=" + int1 + ", int2=" + int2 + ", string1="
				+ string1 + ", string2=" + string2 + ", stateId=" + stateId + ", qualification=" + qualification
				+ ", profilePhoto=" + profilePhoto + ", countryId=" + countryId + ", refferalCode=" + refferalCode
				+ ", webToken=" + webToken + ", motherName=" + motherName + "]";
	}

	 

	

	 

	
	
	 

}
