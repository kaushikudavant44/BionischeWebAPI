package com.bionische.biotech.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

import com.bionische.biotech.Common.DateConverter;

@Entity
@Table(name="rating_details")
public class RatingDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rating_review_id")
	private int ratingReviewId;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="rating")
	private float rating;
	
	@Column(name="review")
	private String review;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="patient_name")
   private String patientName;
	
	@Column(name="int_1")
     private int int1;
	
	@Column(name="int_2")
      private int int2;
	
	@Column(name="string_1")
     private String string1;
    
	@Column(name="string_2")
    private String string2;
	
	@Column(name="del_status")
   private int delStatus;
	
	@Column(name = "created_date")
	private String createDate;
    
	public String getCreateDate() {
		return DateConverter.convertToDMY(createDate);
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getRatingReviewId() {
		return ratingReviewId;
	}
	public void setRatingReviewId(int ratingReviewId) {
		this.ratingReviewId = ratingReviewId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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
	@Override
	public String toString() {
		return "RatingDetails [ratingReviewId=" + ratingReviewId + ", doctorId=" + doctorId + ", rating=" + rating
				+ ", review=" + review + ", patientId=" + patientId + ", patientName=" + patientName + ", int1=" + int1
				+ ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + ", delStatus=" + delStatus
				+ ", createDate=" + createDate + "]";
	}
	 
	
	 

}
