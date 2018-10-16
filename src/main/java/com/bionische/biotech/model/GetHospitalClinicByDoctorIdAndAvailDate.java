package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

 

@Entity
public class GetHospitalClinicByDoctorIdAndAvailDate {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="hospital_id")
	private int hospitalId;
	
	@Column(name="hospital_name")
	private String hospitalName;
	
	@Column(name="type")
	private int hospitalType;

	@Column(name="contact_no")
	private String contactNo;

	@Column(name="email_id")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="cityid")
	private int cityId;
	
	@Column(name="city_name")
	private String cityName;
	
	@Column(name="lat")
	private float latitude;
	
	@Column(name="longitude")
	private float longitude;
	
	@Column(name="available_time")
	private String availableTime;
	
	@Transient
	private String fromTime;
	
	@Transient
	private String toTime;

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

 

	public int getHospitalType() {
		return hospitalType;
	}

	public void setHospitalType(int hospitalType) {
		this.hospitalType = hospitalType;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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
		return "GetHospitalClinicByDoctorIdAndAvailDate [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName
				+ ", hospitalType=" + hospitalType + ", contactNo=" + contactNo + ", email=" + email + ", address="
				+ address + ", cityId=" + cityId + ", cityName=" + cityName + ", latitude=" + latitude + ", longitude="
				+ longitude + ", availableTime=" + availableTime + ", fromTime=" + fromTime + ", toTime=" + toTime
				+ "]";
	}

	 
	 

	 
	
}
