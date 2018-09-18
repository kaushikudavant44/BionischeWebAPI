package com.bionische.biotech.yoga.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class GetYogaTeacherDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	
	@Column(name="teacher_id")  
	private int teacherId;

@Column(name="rating")  
private float rating;
	
	
	@Column(name="location")  
private String location;
	
	@Column(name="city_id")  
private int cityId;
	
	@Column(name="m_name")  
private String mName;
	
	@Column(name="l_name")  
private String lName;
	
	
	@Column(name="f_name")  
private String fName;
	
	@Column(name="address")  
private String address;
		
	
	@Column(name="education")  
private String education;
	
	@Column(name="institute_name")  
private String instituteName;
	
	@Column(name="experience")  
private String experience;
	
	@Column(name="contact")  
private String contactNo;

	@Column(name="profile_photo")  
private String profilePhoto;
    
	@Column(name="email")  
private String email;
	
		

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public String getProfilePhoto() {
		return profilePhoto;
	}

	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	
	
	
	
	 public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	
	
	 
	
	
	public String getInstituteName() {
		return instituteName;
	}

	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}




	

    
    
    public String getExperience() {
		return experience;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	

	
	

	@Override
	public String toString() {
		return "GetYogaTeacherDetails [teacherId=" + teacherId + ", rating=" + rating + ", cityId=" + cityId
				+ ", mName=" + mName + ", lName=" + lName + ", fName=" + fName + ", address=" + address + ", education="
				+ education + ", instituteName=" + instituteName + ", experience=" + experience + ", contactNo="
				+ contactNo + ", profilePhoto=" + profilePhoto + ", email=" + email + ", location=" + location + "]";
	}
	
	 

	
	}

	
	
	

	