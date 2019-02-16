package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetLabForAppointment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "lab_id")
	private int labId;

	@Column(name = "city_id")
	private int cityId;

	@Column(name = "city_name")
	private String cityName;

	@Column(name = "lab_name")
	private String labName;

	@Column(name = "address")
	private String address;

	@Column(name = "from_time")
	private String fromTime;

	@Column(name = "to_time")
	private String toTime;

	@Column(name = "lic_no")
	private String licenceNo;

	@Column(name = "photo")
	private String photo;

	private float rating;

	@Column(name = "contact")
	private String contact;

	@Column(name = "email")
	private String email;

	@Column(name = "lat")
	private double lat;

	@Column(name = "longitude")
	private double longitude;
	
	@Column(name="tests_types")
	private String teststypes;
	
	@Column(name="tests_name")
	private String testName;
	

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
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

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getTeststypes() {
		return teststypes;
	}

	public void setTeststypes(String teststypes) {
		this.teststypes = teststypes;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	@Override
	public String toString() {
		return "GetLabForAppointment [labId=" + labId + ", cityId=" + cityId + ", cityName=" + cityName + ", labName="
				+ labName + ", address=" + address + ", fromTime=" + fromTime + ", toTime=" + toTime + ", licenceNo="
				+ licenceNo + ", photo=" + photo + ", rating=" + rating + ", contact=" + contact + ", email=" + email
				+ ", lat=" + lat + ", longitude=" + longitude + ", teststypes=" + teststypes + ", testName=" + testName
				+ "]";
	}

 
	
}
