package com.bionische.biotech.yoga.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="yogateacher_details")

public class YogaTeacherDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="teacher_id")
	private int teacherId;
	
	@Column(name="uname")
private String userName;
	
	@Column(name="yoga_types")
	private String yogaTypes;
	
	@Column(name="password")
private String password;
	
	@Column(name="experience")
private String experience;
	

	@Column(name="education")
private String education;
	
 
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
	@Column(name="del_status")
	private int delStatus;
    
    

	@Column(name="country_id")
private int countryId;
	
	@Column(name="address")
private String address;

	
	@Column(name="date")
private String date;

	
	@Column(name="time")
private String time;

	
	@Column(name="profile_photo")
private String profilePhoto;
	
	@Column(name="contact")
private String contactNo;
	
	@Column(name="email")
private String email;
	
	@Column(name="institute_name")
private String instituteName;
	
	@Column(name="location")
private String location;
	
	
	@Column(name="health_types")
private String healthWellnessTypes;
	
	public String getHealthWellnessTypes() {
		return healthWellnessTypes;
	}

	public void setHealthWellnessTypes(String healthWellnessTypes) {
		this.healthWellnessTypes = healthWellnessTypes;
	}

	public String getPranayamaTypes() {
		return pranayamaTypes;
	}

	public void setPranayamaTypes(String pranayamaTypes) {
		this.pranayamaTypes = pranayamaTypes;
	}

	public String getDailyRoutineTypes() {
		return dailyRoutineTypes;
	}

	public void setDailyRoutineTypes(String dailyRoutineTypes) {
		this.dailyRoutineTypes = dailyRoutineTypes;
	}

	@Column(name="pranayama_types")
private String pranayamaTypes;
	
	@Column(name="dailyroutine_types")
private String dailyRoutineTypes;


	
	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name="string1")
private String string1;
	
	@Column(name="string2")
private String string2;
	
	@Column(name="int_1")
private int int1;
	
	@Column(name="int_2")
private int int2;

	public int getTeacherId() {
		return teacherId;
	} 

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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

	public int getInt1() {
		return int1;
	}

	public String getYogaTypes() {
		return yogaTypes;
	}

	public void setYogaTypes(String yogaTypes) {
		this.yogaTypes = yogaTypes;
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

	@Override
	public String toString() {
		return "YogaTeacherDetails [teacherId=" + teacherId + ", userName=" + userName + ", yogaTypes=" + yogaTypes
				+ ", password=" + password + ", experience=" + experience + ", education=" + education + ", fName="
				+ fName + ", lName=" + lName + ", mName=" + mName + ", gender=" + gender + ", cityId=" + cityId
				+ ", stateId=" + stateId + ", delStatus=" + delStatus + ", countryId=" + countryId + ", address="
				+ address + ", date=" + date + ", time=" + time + ", profilePhoto=" + profilePhoto + ", contactNo="
				+ contactNo + ", email=" + email + ", instituteName=" + instituteName + ", location=" + location
				+ ", healthWellnessTypes=" + healthWellnessTypes + ", pranayamaTypes=" + pranayamaTypes
				+ ", dailyRoutineTypes=" + dailyRoutineTypes + ", string1=" + string1 + ", string2=" + string2
				+ ", int1=" + int1 + ", int2=" + int2 + "]";
	}

	
}
