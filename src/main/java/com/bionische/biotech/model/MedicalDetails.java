package com.bionische.biotech.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medical_details")

public class MedicalDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="medical_id")
	private int medicalId;
	
	@Column(name="state_id")
    private int stateId;
	
	@Column(name="country_id")
     private int countryId;

	@Column(name="city_id")
    private int cityId;
	


	@Column(name="medical_name")
    private String medicalName;
		
	@Column(name="address")
    private String address;
		
		 
	@Column(name="owner")
    private String owner;
		
	 
	@Column(name="licence_no")
   private String licenceNo;
		
 		 
	@Column(name="photo")
   private String photo;
		
		 
	@Column(name="del_status")
    private int delStatus;
		
		 
	@Column(name="contact")
    private String contact;
		
	 
	@Column(name="email")
    private String email;

	 
	@Column(name="latitude")
    private float latitude;
		
	@Column(name="longitude")
   private float longitude;
		
	@Column(name="username")
   private String userName;
		
	@Column(name="password")
    private String password;
		
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


	public int getMedicalId() {
		return medicalId;
	}


	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}


	public String getMedicalName() {
		return medicalName;
	}


	public void setMedicalName(String medicalName) {
		this.medicalName = medicalName;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
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


	public int getDelStatus() {
		return delStatus;
	}


	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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
		return "MedicalDetails [cityId=" + cityId + ", stateId=" + stateId + ", countryId=" + countryId + ", medicalId="
				+ medicalId + ", medicalName=" + medicalName + ", address=" + address + ", owner=" + owner
				+ ", licenceNo=" + licenceNo + ", photo=" + photo + ", delStatus=" + delStatus + ", contact=" + contact
				+ ", email=" + email + ", latitude=" + latitude + ", longitude=" + longitude + ", userName=" + userName
				+ ", password=" + password + ", int1=" + int1 + ", int2=" + int2 + ", int3=" + int3 + ", string1="
				+ string1 + ", string2=" + string2 + ", string3=" + string3 + "]";
	}
		
	 
	

	
	}

	
	 
	

	
	
	

