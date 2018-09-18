package com.bionische.biotech.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stemcell_patient")

public class StemcellDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="patient_id")
	private int patientId;
	@Column(name="patient_name")
	private String patientName;
		
		@Column(name="addr")
	private String addr;
		
		@Column(name="contact1")
	private int contact1;
		
		@Column(name="contact2")
	private int contact2;
		

		@Column(name="email")
	private String email;
		
		@Column(name="bloodgroup")
	private String bloodGroup;
		
		@Column(name="gender")
	private String gender;
		
		@Column(name="birth_date")
	private String birthDate;
		
		@Column(name="age")
	private String age;
		
		@Column(name="photo")
	private String profilePhoto;
		
		@Column(name="state")
	private String state;
		
		@Column(name="country")
	private String country;
		
		@Column(name="marital_status")
	private String maritalStatus;
		
		@Column(name="del_status")
	private int delStatus;
		
		@Column(name="int_1")
	private int int1;
		
		@Column(name="int_2")
	private int int2;
		
		@Column(name="string1")
	private String string1;
		
		@Column(name="string2")
	private String string2;
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getContact1() {
		return contact1;
	}

	public void setContact1(int contact1) {
		this.contact1 = contact1;
	}

	public int getContact2() {
		return contact2;
	}

	public void setContact2(int contact2) {
		this.contact2 = contact2;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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

	
		@Override
		public String toString() {
			return "StemcellDetails [patientId=" + patientId + ", patientName=" + patientName + ", addr=" + addr
					+ ", contact1=" + contact1 + ", contact2=" + contact2 + ", email=" + email + ", bloodGroup="
					+ bloodGroup + ", gender=" + gender + ", birthDate=" + birthDate + ", age=" + age
					+ ", profilePhoto=" + profilePhoto + ", state=" + state + ", country=" + country
					+ ", maritalStatus=" + maritalStatus + ", delStatus=" + delStatus + ", int1=" + int1 + ", int2="
					+ int2 + ", string1=" + string1 + ", string2=" + string2 + "]";
		}

	

	
}
