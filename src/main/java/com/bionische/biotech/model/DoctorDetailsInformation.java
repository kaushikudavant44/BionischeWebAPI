package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorDetailsInformation {
	
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
	
	@Column(name="state_id")
    private int stateId;
	
	@Column(name="country_id")
	private int countryId;
	
	@Column(name="address")
	private String address;
	
	
	@Column(name="year_of_exp")
	private int yearOfExperience;
	
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
	
	@Column(name="council_reg_no")
	private String councilRegNo;
	
	@Column(name="council_name")
	private String councilName;
 
	@Column(name="fees")
	private float fees;
	
	@Column(name="rating")
	private float rating;
	
	@Column(name="spec_type")
	private String specializationType;
	
	@Column(name="cityName")
	private String cityName;
	
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public String getSpecializationType() {
		return specializationType;
	}

	public void setSpecializationType(String specializationType) {
		this.specializationType = specializationType;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public int getYearOfExperience() {
		return yearOfExperience;
	}

	public void setYearOfExperience(int yearOfExperience) {
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

	@Override
	public String toString() {
		return "DoctorDetailsInformation [doctorId=" + doctorId + ", fName=" + fName + ", lName=" + lName + ", mName="
				+ mName + ", gender=" + gender + ", cityId=" + cityId + ", stateId=" + stateId + ", countryId="
				+ countryId + ", address=" + address + ", yearOfExperience=" + yearOfExperience + ", aboutMe=" + aboutMe
				+ ", profilePhoto=" + profilePhoto + ", contactNo=" + contactNo + ", email=" + email
				+ ", qualification=" + qualification + ", college=" + college + ", passingYear=" + passingYear
				+ ", specId=" + specId + ", councilRegNo=" + councilRegNo + ", councilName=" + councilName + ", fees="
				+ fees + ", rating=" + rating + ", specializationType=" + specializationType + ", cityName=" + cityName
				+ "]";
	}


	
	
}
