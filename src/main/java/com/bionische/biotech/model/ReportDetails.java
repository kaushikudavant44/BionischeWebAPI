package com.bionische.biotech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="patient_reports")
public class ReportDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="report_id")
	private int reportId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="lab_test_id")
    private int labTestId;
	
	@Column(name="lab_id")
    private int labId;
	
	@Column(name="report_file_name")
	private String reportFileName;
	
	@Column(name="report_date")
	private String reportDate;
	
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
	
	@Column(name="report_time")
	private String reportTime;
	
	 
	 
 
	
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public int getLabId() {
		return labId;
	}
	public void setLabId(int labId) {
		this.labId = labId;
	}
	public String getReportTime() {
		return reportTime;
	}
	
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public int getLabTestId() {
		return labTestId;
	}
	public void setLabTypesId(int labTestId) {
		this.labTestId = labTestId;
	}
	
	public String getReportFileName() {
		return reportFileName;
	}
	public void setReportFileName(String reportFileName) {
		this.reportFileName = reportFileName;
	}
	public void setLabTestId(int labTestId) {
		this.labTestId = labTestId;
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

	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	@Override
	public String toString() {
		return "ReportDetails [reportId=" + reportId + ", patientId=" + patientId + ", labTestId=" + labTestId
				+ ", labId=" + labId + ", reportFileName=" + reportFileName + ", reportDate=" + reportDate + ", int1="
				+ int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + ", delStatus=" + delStatus
				+ ", reportTime=" + reportTime + "]";
	}
	
	
	
	
	
}
