package com.bionische.biotech.bloodbank.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;


@Entity
@Table(name="bloodbankrating_details")
public class BloodBankRatingDetails {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	
	
@Column(name="rating_review_id")
private int ratingReviewId;


public int getRatingReviewId() {
	return ratingReviewId;
}


public void setRatingReviewId(int ratingReviewId) {
	this.ratingReviewId = ratingReviewId;
}


public int getBloodBankId() {
	return bloodBankId;
}


public void setBloodBankId(int bloodBankId) {
	this.bloodBankId = bloodBankId;
}


public float getRating() {
	return rating;
}


public void setRating(float rating) {
	this.rating = rating;
}


public String getReview() {
	return review;
}


public void setReview(String review) {
	this.review = review;
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


public int getDelStatus() {
	return delStatus;
}


public void setDelStatus(int delStatus) {
	this.delStatus = delStatus;
}


public String getDate() {
	return DateConverter.convertToDMY(date);
}


public void setDate(String date) {
	this.date = date;
}


@Column(name="bloodbank_id")
private int bloodBankId;
	      
	@Column(name="rating")
private float rating;  
	
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


	@Column(name="review")
private String review;
	
	@Column(name="hospital_id")
private int hospitalId;   
	
	@Column(name="hospital_name")
private String hospitalName;
	
	@Column(name="int_1")
private int int1;
	
	@Column(name="int_2")
private int int2;
	
	@Column(name="string1")
 private String string1;
	
	
	@Column(name="string2")
private String string2;
	
	
	@Column(name="del_status")
 private int delStatus;
	
	
@Column(name="date")
private String date;


@Override
public String toString() {
	return "BloodBankRatingDetails [ratingReviewId=" + ratingReviewId + ", bloodBankId=" + bloodBankId + ", rating="
			+ rating + ", review=" + review + ", hospitalId=" + hospitalId + ", hospitalName=" + hospitalName
			+ ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + ", delStatus="
			+ delStatus + ", date=" + date + "]";
}



	
	


}
