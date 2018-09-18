package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stemcellrating_details")
public class StemCellRatingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rating_review_id")
	private int ratingReviewId;
	
	@Column(name="stemcell_id")
private int stemCellId;
	
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
	
	@Column(name="string1")
 private String string1;
	
	@Column(name="string2")
private String string2;
	
	@Column(name="del_status")
private int delStatus;
	
	public int getRatingReviewId() {
		return ratingReviewId;
	}
	public void setRatingReviewId(int ratingReviewId) {
		this.ratingReviewId = ratingReviewId;
	}
	public int getStemCellId() {
		return stemCellId;
	}
	public void setStemCellId(int stemCellId) {
		this.stemCellId = stemCellId;
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
		return "StemCellRatingDetails [ratingReviewId=" + ratingReviewId + ", stemCellId=" + stemCellId + ", rating="
				+ rating + ", review=" + review + ", patientId=" + patientId + ", patientName=" + patientName
				+ ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + ", delStatus="
				+ delStatus + "]";
	}
	
	
	
}
