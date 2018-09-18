package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetReportDetailsForLab {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="report_id")
    private int reportId;
	
	@Column(name="f_name")
	private String patientFname;
	
	@Column(name="l_name")
	private String patientLname;
	
	@Column(name="report_file_name")
	private String reportName;
	
	@Column(name="report_date")
	private String reportDate;
	
	@Column(name="report_time")
	private String reportTime;
	
	@Column(name="lab_test_name")
	private String testName;
	
	@Column(name="int_1")
	private String int1;
	
	@Column(name="patient_id")
    private int patientId;
	
	@Column(name="lab_id")
	private int labId;
	
	@Column(name="lab_name")
	private String labName;
	
	@Column(name="del_status")
    private String delStatus;
	
	@Column(name="int_2")
	private int int2;   

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getPatientFname() {
		return patientFname;
	}

	public void setPatientFname(String patientFname) {
		this.patientFname = patientFname;
	}

	public String getPatientLname() {
		return patientLname;
	}

	public void setPatientLname(String patientLname) {
		this.patientLname = patientLname;
	}

	public String getReportName() {
		return reportName;
	}

	public void setReportName(String reportName) {
		this.reportName = reportName;
	}

	public String getReportDate() {
		return reportDate;
	}

	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getInt1() {
		return int1;
	}

	public void setInt1(String int1) {
		this.int1 = int1;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public String getLabName() {
		return labName;
	}

	public void setLabName(String labName) {
		this.labName = labName;
	}

	public String getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(String delStatus) {
		this.delStatus = delStatus;
	}

	public int getInt2() {
		return int2;
	}

	public void setInt2(int int2) {
		this.int2 = int2;
	}

	@Override
	public String toString() {
		return "GetReportDetailsForLab [reportId=" + reportId + ", patientFname=" + patientFname + ", patientLname="
				+ patientLname + ", reportName=" + reportName + ", reportDate=" + reportDate + ", reportTime="
				+ reportTime + ", testName=" + testName + ", int1=" + int1 + ", patientId=" + patientId + ", labId="
				+ labId + ", labName=" + labName + ", delStatus=" + delStatus + ", int2=" + int2 + "]";
	}

	

}
