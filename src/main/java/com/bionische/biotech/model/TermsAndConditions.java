package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;

@Entity
@Table(name="terms_and_conditions")
public class TermsAndConditions {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="term_and_condition_id")
	private int termAndConditionId;
	
	@Column(name="user_type")
	private int userType;
	
	
	@Column(name="terms_and_conditions")
	private String termsAndConditions;
	
	
	@Column(name="date")
	private String date;
	
	
	@Column(name="del_status")
	private int delStatus;
	

	@Column(name="string1")
	private String string1;
	

	@Column(name="string2")
	private String string2;
	
	@Column(name="int_1")
	private int int_1;
	
	@Column(name="int_2")
	private int int_2;

	public int getTermAndConditionId() {
		return termAndConditionId;
	}

	public void setTermAndConditionId(int termAndConditionId) {
		this.termAndConditionId = termAndConditionId;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	public String getDate() {
		return DateConverter.convertToDMY(date);
	}

	public void setDate(String date) {
		this.date = date;
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

	public int getInt_1() {
		return int_1;
	}

	public void setInt_1(int int_1) {
		this.int_1 = int_1;
	}

	public int getInt_2() {
		return int_2;
	}

	public void setInt_2(int int_2) {
		this.int_2 = int_2;
	}

	@Override
	public String toString() {
		return "TermsAndConditions [termAndConditionId=" + termAndConditionId + ", userType=" + userType
				+ ", termsAndConditions=" + termsAndConditions + ", date=" + date + ", delStatus=" + delStatus
				+ ", string1=" + string1 + ", string2=" + string2 + ", int_1=" + int_1 + ", int_2=" + int_2 + "]";
	}
	
		 							 
}
