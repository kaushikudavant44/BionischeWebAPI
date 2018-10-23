package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class GetDoctorListForAppointment {

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
	
	@Column(name="city_id")
	private int cityId;
	
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
	

	@Column(name="fees")
	private float fees;
	
 	@Column(name="hospital_id")
	private int hospitalId;  
	

	@Column(name="hospital_name")
	private String hospitalName;
	
	@Column(name="hospital_address")
	private String hospitalAddress;
	
	@Column(name="hospital_contact_no")
	private String hospitalContactNo;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="lat")
	private float latitude;
	
	@Column(name="longitude")
	private float longitude;
	
	@Column(name="available_time")
	private String availableTime;
 
	@Column(name="council_reg_no")
	private String councilRegNo;
	
	@Column(name="council_name")
	private String councilName;
	
	@Transient
	private String fromTime;
	
	@Transient
	private String toTime;
	
	private float rating;

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

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getSpecType() {
		return specType;
	}

	public void setSpecType(String specType) {
		this.specType = specType;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(String hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	public String getHospitalContactNo() {
		return hospitalContactNo;
	}

	public void setHospitalContactNo(String hospitalContactNo) {
		this.hospitalContactNo = hospitalContactNo;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}

	public String getFromTime() {
		return fromTime;
	}

	public void setFromTime(String fromTime) {
		this.fromTime = fromTime;
	}

	public String getToTime() {
		return toTime;
	}

	public void setToTime(String toTime) {
		this.toTime = toTime;
	}

	@Override
	public String toString() {
		return "GetDoctorListForAppointment [doctorId=" + doctorId + ", fName=" + fName + ", lName=" + lName
				+ ", mName=" + mName + ", cityId=" + cityId + ", address=" + address + ", yearOfExperience="
				+ yearOfExperience + ", aboutMe=" + aboutMe + ", profilePhoto=" + profilePhoto + ", contactNo="
				+ contactNo + ", email=" + email + ", qualification=" + qualification + ", college=" + college
				+ ", passingYear=" + passingYear + ", specId=" + specId + ", specType=" + specType + ", fees=" + fees
				+ ", hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalAddress="
				+ hospitalAddress + ", hospitalContactNo=" + hospitalContactNo + ", cityName=" + cityName
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", availableTime=" + availableTime
				+ ", councilRegNo=" + councilRegNo + ", councilName=" + councilName + ", fromTime=" + fromTime
				+ ", toTime=" + toTime + ", rating=" + rating + "]";
	}

	 
	 
	
	
	
}
