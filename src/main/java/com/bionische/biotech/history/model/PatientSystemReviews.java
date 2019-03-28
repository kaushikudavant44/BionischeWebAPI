package com.bionische.biotech.history.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_sys_reviews")

public class PatientSystemReviews {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="patient_sys_reviewsid")
	private int patient_Sys_ReviewsId;
	
	
	@Column(name="detail_id")
	private String detailId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="age_ofperiods")
	private String ageOFPeriods;
	
	@Column(name="age_ofpregnancies")
	private String Pregnancies;
	
	@Column(name="age_ofabortions")
	private String abortions;
	
	@Column(name="age_ofMmscarriages")
	private String Miscarriages;
	
	@Column(name="regular_periods")
	private String regularPeriods;
	
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

	public int getPatient_Sys_ReviewsId() {
		return patient_Sys_ReviewsId;
	}

	public void setPatient_Sys_ReviewsId(int patient_Sys_ReviewsId) {
		this.patient_Sys_ReviewsId = patient_Sys_ReviewsId;
	}
 
	public String getDetailId() {
		return detailId;
	}

	public void setDetailId(String detailId) {
		this.detailId = detailId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getDate() {
		return DateConverter.convertToDMY(date);
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAgeOFPeriods() {
		return ageOFPeriods;
	}

	public void setAgeOFPeriods(String ageOFPeriods) {
		this.ageOFPeriods = ageOFPeriods;
	}

	public String getPregnancies() {
		return Pregnancies;
	}

	public void setPregnancies(String pregnancies) {
		Pregnancies = pregnancies;
	}

	public String getAbortions() {
		return abortions;
	}

	public void setAbortions(String abortions) {
		this.abortions = abortions;
	}

	public String getMiscarriages() {
		return Miscarriages;
	}

	public void setMiscarriages(String miscarriages) {
		Miscarriages = miscarriages;
	}

	public String getRegularPeriods() {
		return regularPeriods;
	}

	public void setRegularPeriods(String regularPeriods) {
		this.regularPeriods = regularPeriods;
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
		return "PatientSystemReviews [patient_Sys_ReviewsId=" + patient_Sys_ReviewsId + ", detailId=" + detailId
				+ ", patientId=" + patientId + ", date=" + date + ", ageOFPeriods=" + ageOFPeriods + ", Pregnancies="
				+ Pregnancies + ", abortions=" + abortions + ", Miscarriages=" + Miscarriages + ", regularPeriods="
				+ regularPeriods + ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2 + ", string1="
				+ string1 + ", string2=" + string2 + "]";
	}
   
	
	}
	
	
	
	

	
	


