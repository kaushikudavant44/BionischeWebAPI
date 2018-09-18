package com.bionische.biotech.radiology.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_details")
public class TestDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "test_id")
	private int testId;

	@Column(name = "doctor_id")
	private int doctorId;

	@Column(name = "modality_id")
	private int modalityId;

	@Column(name = "modality_name")
	private String modalityName;

	@Column(name = "test")
	private String test;

	@Column(name = "del_status")
	private int delStatus;

	@Column(name = "int_1")
	private int int_1;

	@Column(name = "int_2")
	private int int_2;

	@Column(name = "string_2")
	private String string2;

	@Column(name = "test_requirement")
	private String testRequirement;

	public String getTestRequirement() {
		return testRequirement;
	}

	public void setTestRequirement(String testRequirement) {
		this.testRequirement = testRequirement;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getModalityId() {
		return modalityId;
	}

	public void setModalityId(int modalityId) {
		this.modalityId = modalityId;
	}

	public String getModalityName() {
		return modalityName;
	}

	public void setModalityName(String modalityName) {
		this.modalityName = modalityName;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	@Override
	public String toString() {
		return "TestDetails [testId=" + testId + ", doctorId=" + doctorId + ", modalityId=" + modalityId
				+ ", modalityName=" + modalityName + ", test=" + test + ", delStatus=" + delStatus + ", int_1=" + int_1
				+ ", int_2=" + int_2 + ", string2=" + string2 + ", testRequirement=" + testRequirement + "]";
	}

}
