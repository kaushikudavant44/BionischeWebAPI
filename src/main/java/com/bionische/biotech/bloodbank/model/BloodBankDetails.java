package com.bionische.biotech.bloodbank.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bloodbank_details")

public class BloodBankDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="bloodbank_id")
    private int bloodBankId;   
	
	@Column(name="bloodbank_name")
	private String bloodBankName;
		
		
	@Column(name="bloodbank_cityid")
	private int cityId;
		
    @Column(name="bloodbank_contact")
	private String bloodBankContact;
		
	@Column(name="bloodbank_emailid")
	private String bloodBankEmailId;
	
	@Column(name="location")
	private String location;
		
	@Column(name="bloodbank_address")
	private String bloodBankAddress;
	

    @Column(name="state_id")
	private int stateId;
		
	@Column(name="country_id")
	private int countryId;
		
    @Column(name="int_1")
	private int int1;
    
    
    @Column(name="int_2")
	private int int2;
    
    @Column(name="string1")
	private String String1;
		
		@Column(name="string2")
	private String String2;
		
		@Column(name="del_status")
	private int delStatus;
		
		@Column(name="image")
	private String photo;

		
		public int getBloodBankId() {
		return bloodBankId;
	}

	public void setBloodBankId(int bloodBankId) {
		this.bloodBankId = bloodBankId;
	}

	public String getBloodBankName() {
		return bloodBankName;
	}

	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName = bloodBankName;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getBloodBankContact() {
		return bloodBankContact;
	}

	public void setBloodBankContact(String bloodBankContact) {
		this.bloodBankContact = bloodBankContact;
	}

	public String getBloodBankEmailId() {
		return bloodBankEmailId;
	}

	public void setBloodBankEmailId(String bloodBankEmailId) {
		this.bloodBankEmailId = bloodBankEmailId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBloodBankAddress() {
		return bloodBankAddress;
	}

	public void setBloodBankAddress(String bloodBankAddress) {
		this.bloodBankAddress = bloodBankAddress;
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
		return String1;
	}

	public void setString1(String string1) {
		String1 = string1;
	}

	public String getString2() {
		return String2;
	}

	public void setString2(String string2) {
		String2 = string2;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "BloodBankDetails [bloodBankId=" + bloodBankId + ", bloodBankName=" + bloodBankName + ", cityId="
				+ cityId + ", bloodBankContact=" + bloodBankContact + ", bloodBankEmailId=" + bloodBankEmailId
				+ ", location=" + location + ", bloodBankAddress=" + bloodBankAddress + ", stateId=" + stateId
				+ ", countryId=" + countryId + ", int1=" + int1 + ", int2=" + int2 + ", String1=" + String1
				+ ", String2=" + String2 + ", delStatus=" + delStatus + ", photo=" + photo + "]";
	}

		
		
   
	
	

	

}
