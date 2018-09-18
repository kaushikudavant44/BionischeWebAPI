package com.bionische.biotech.insurance.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="insurance_review")


public class InsuranceReview {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="company_review_id")
	private int reviewId;
	
	@Column(name="company_id")
	private int companyId;
		
	
	@Column(name="company_review")
private String companyReview;
	
	@Column(name="int_1")
private int int1;
	
  
	@Column(name="int_2")
private int int2;

	@Column(name="del_status")
private int delStatus;
	
	@Column(name="string1")
private String string1;
	
	@Column(name="string2")
private String string2;
	
	@Column(name="patient_id")
private int patientId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="patient_name")
	private String patientname;

	
 

	public String getPatientname() {
		return patientname;
	}

	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	 

	public String getCompanyReview() {
		return companyReview;
	}

	public void setCompanyReview(String companyReview) {
		this.companyReview = companyReview;
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

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Override
	public String toString() {
		return "InsuranceReview [reviewId=" + reviewId + ", companyId=" + companyId + ", companyReview=" + companyReview
				+ ", int1=" + int1 + ", int2=" + int2 + ", delStatus=" + delStatus + ", string1=" + string1
				+ ", string2=" + string2 + ", patientId=" + patientId + ", date=" + date + ", patientname="
				+ patientname + "]";
	}

	 
 
	
}
