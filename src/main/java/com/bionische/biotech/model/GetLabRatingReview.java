package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lab_rating_review")

public class GetLabRatingReview {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rating_review_id")
	private int ratingReviewId;

	@Column(name = "lab_id")
	private int labId;

	@Column(name = "patient_id")
	private int patientId;

	@Column(name = "rating")
	private float rating;

	@Column(name = "review")
	private String review;

	@Column(name = "patient_name")
	private String patientName;

	@Column(name = "string_1")
	private String string1;

	@Column(name = "date")
	private String date;

	@Column(name = "int_2")
	private int int2;

	@Column(name = "int_1")
	private int int1;

	@Column(name = "del_status")
	private int delStatus;

	public int getRatingReviewId() {
		return ratingReviewId;
	}

	public void setRatingReviewId(int ratingReviewId) {
		this.ratingReviewId = ratingReviewId;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
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

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "GetLabRatingReview [ratingReviewId=" + ratingReviewId + ", labId=" + labId + ", patientId=" + patientId
				+ ", rating=" + rating + ", review=" + review + ", patientName=" + patientName + ", string1=" + string1
				+ ", date=" + date + ", int2=" + int2 + ", int1=" + int1 + ", delStatus=" + delStatus + "]";
	}

	
	
}
