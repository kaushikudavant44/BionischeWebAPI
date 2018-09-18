package com.bionische.biotech.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hospital_details")

public class HospitalDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="hospital_id")
    private int hospitalId;
	
	@Column(name="hospital_name")
	private String hospitalName;

	@Column(name="cityid")
	private int cityId;
	@Column(name="state_id")
	private int stateId;

	@Column(name="country_id")
	private int countryId;

	@Column(name="address")
	private String address;

	@Column(name="contact_no")
	private int contactNo;

	@Column(name="email_id")
	private String email;

	@Column(name="int_1")
	private int int1;

	@Column(name="int_2")
	private int int2;

	@Column(name="string1")
	private String string1;

	@Column(name="string2")
	private String string2;

	@Column(name="del_status")
	private int delstatus;
	
	@Column(name="lat")
	private float latitude;
	
	@Column(name="longitude")
	private float longitude;

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

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getDelstatus() {
		return delstatus;
	}

	public void setDelstatus(int delstatus) {
		this.delstatus = delstatus;
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

	@Override
	public String toString() {
		return "HospitalDetails [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", cityId=" + cityId
				+ ", stateId=" + stateId + ", countryId=" + countryId + ", address=" + address + ", contactNo="
				+ contactNo + ", email=" + email + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1
				+ ", string2=" + string2 + ", delstatus=" + delstatus + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}


}






