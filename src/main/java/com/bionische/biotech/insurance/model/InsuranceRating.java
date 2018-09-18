package com.bionische.biotech.insurance.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_rating")



public class InsuranceRating {
	
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="rating_id")
private int ratingId;
	
	@Column(name="insurance_rating")
private float insurancecRating;
	
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
	
	
	@Column(name="company_id")
	private int companyId;


	public int getRatingId() {
		return ratingId;
	}


	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}


	public float getInsurancecRating() {
		return insurancecRating;
	}


	public void setInsurancecRating(float insurancecRating) {
		this.insurancecRating = insurancecRating;
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
		return "InsuranceRating [ratingId=" + ratingId + ", insurancecRating=" + insurancecRating + ", int1=" + int1
				+ ", int2=" + int2 + ", delStatus=" + delStatus + ", string1=" + string1 + ", string2=" + string2
				+ ", companyId=" + companyId + "]";
	}
  

}
