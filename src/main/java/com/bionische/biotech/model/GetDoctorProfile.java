package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetDoctorProfile {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="doctor_id")
	private int doctorId;
	
	
	@Column(name="f_name")
	private String fName;
	
	@Column(name="l_name")
	private String lName; 
	
	@Column(name="m_name")
	private String mName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="city_id")
	private int cityId;
	
	@Column(name="fees")
	private float fees;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="state_id")
    private int stateId;
	
	@Column(name="country_id")
	private int countryId;
	
	@Column(name="hospital_id")
	private int hospitalId;
	
	@Column(name="address")
	private String address;
	
	
	@Column(name="year_of_exp")
	private String yearOfExperience;
	
	@Column(name="about_me")
	private String aboutMe;
	
	@Column(name="profile_photo")
	private String profilePhoto;
	
	@Column(name="contact")
	private String contactNo;
	
	@Column(name="email")
	private String email;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="college")
	private String college;
	
	@Column(name="passing_year")
	private String passingYear;
	
	@Column(name="spec_id")
	private int specId;
	
	@Column(name="spec_type")
	private String specType;
	
	@Column(name="int_2")
	private int int2;
	
 
	@Column(name="council_reg_no")
	private String councilRegNo;
	
	@Column(name="council_name")
	private String councilName;
	
	@Column(name="del_status")
	private int delStatus;

	
	
	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(String yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(String passingYear) {
		this.passingYear = passingYear;
	}

	public int getSpecId() {
		return specId;
	}

	public void setSpecId(int specId) {
		this.specId = specId;
	}

	public String getSpecType() {
		return specType;
	}

	public void setSpecType(String specType) {
		this.specType = specType;
	}

	public String getCouncilRegNo() {
		return councilRegNo;
	}

	public void setCouncilRegNo(String councilRegNo) {
		this.councilRegNo = councilRegNo;
	}

	public String getCouncilName() {
		return councilName;
	}

	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	@Override
	public String toString() {
		return "GetDoctorProfile [doctorId=" + doctorId + ", fName=" + fName + ", lName=" + lName + ", mName=" + mName
				+ ", gender=" + gender + ", cityId=" + cityId + ", fees=" + fees + ", cityName=" + cityName
				+ ", stateId=" + stateId + ", countryId=" + countryId + ", hospitalId=" + hospitalId + ", address="
				+ address + ", yearOfExperience=" + yearOfExperience + ", aboutMe=" + aboutMe + ", profilePhoto="
				+ profilePhoto + ", contactNo=" + contactNo + ", email=" + email + ", qualification=" + qualification
				+ ", college=" + college + ", passingYear=" + passingYear + ", specId=" + specId + ", specType="
				+ specType + ", int2=" + int2 + ", councilRegNo=" + councilRegNo + ", councilName=" + councilName
				+ ", delStatus=" + delStatus + "]";
	}

	

	
	
}
