package com.bionische.biotech.model.lab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;

@Entity
@Table(name="t_patient_report_details")
public class PatientReportsDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int reportId;
	
	private int appointmentId;
	
	private String fileName;
	
	private int status;
	
	private int patientId;
	 
	private String date;
	
 
    private int labTestId; 
    
    private int labId;
    
    private int delStatus;
    
    private int fileType;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

	public int getLabTestId() {
		return labTestId;
	}

	public void setLabTestId(int labTestId) {
		this.labTestId = labTestId;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getFileType() {
		return fileType;
	}

	public void setFileType(int fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return "PatientReportsDetails [reportId=" + reportId + ", appointmentId=" + appointmentId + ", fileName="
				+ fileName + ", status=" + status + ", patientId=" + patientId + ", date=" + date + ", labTestId="
				+ labTestId + ", labId=" + labId + ", delStatus=" + delStatus + ", fileType=" + fileType + "]";
	}

	 
    
}
