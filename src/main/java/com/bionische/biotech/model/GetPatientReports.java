package com.bionische.biotech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class GetPatientReports {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="report_id")
	private int reportId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="lab_test_id")
    private int labTestId;
	
	@Column(name="lab_test_name")
    private String labTestName;
	
	@Column(name="lab_id")
    private int labId;
	
	@Column(name="lab_name")
    private String labName;
	
	@Column(name="report_file_name")
	private String reportFileName;
	
	@Column(name="report_date")
	private String reportDate;
	
	@Column(name="int_1")
    private int int1;
	
	
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getLabTestId() {
		return labTestId;
	}
	public void setLabTestId(int labTestId) {
		this.labTestId = labTestId;
	}
	 
	public String getLabTestName() {
		return labTestName;
	}
	public void setLabTestName(String labTestName) {
		this.labTestName = labTestName;
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
	public String getReportFileName() {
		
		
		return reportFileName;
	}
	public void setReportFileName(String reportFileName) {
		this.reportFileName = reportFileName;
	}
	public int getInt1() {
		return int1;
	}
	public void setInt1(int int1) {
		this.int1 = int1;
	}
	
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	@Override
	public String toString() {
		return "GetPatientReports [reportId=" + reportId + ", patientId=" + patientId + ", labTestId=" + labTestId
				+ ", labTestName=" + labTestName + ", labId=" + labId + ", labName=" + labName + ", reportFileName="
				+ reportFileName + ", reportDate=" + reportDate + ", int1=" + int1 + "]";
	}
	
	
}
