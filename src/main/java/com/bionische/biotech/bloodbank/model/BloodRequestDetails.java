package com.bionische.biotech.bloodbank.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;

@Entity
@Table(name="bloodrequest_details")

public class BloodRequestDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	         
	@Column(name="bloodrequest_id")
    private int bloodRequestId;
	
	@Column(name="blood_group")        
    private String bloodGroup;
	  
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="patient_name")
	private String patientName;
		
	/*@Column(name="bloodbank_id")
	private int bloodBankId;*/
		
	@Column(name="message")
	private String message;
		
	@Column(name="hospitalId")
	private int hospitalId;
		
	@Column(name="time")
	private String time;
		
	@Column(name="date")
	private String date;
		
	@Column(name="status")
	private String status;
	
	public int getBloodRequestId() {
		return bloodRequestId;
	}

	public void setBloodRequestId(int bloodRequestId) {
		this.bloodRequestId = bloodRequestId;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return DateConverter.convertToDMY(date);
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	@Override
	public String toString() {
		return "BloodRequestDetails [bloodRequestId=" + bloodRequestId + ", bloodGroup=" + bloodGroup + ", delStatus="
				+ delStatus + ", patientName=" + patientName + ", message=" + message + ", hospitalId=" + hospitalId
				+ ", time=" + time + ", date=" + date + ", status=" + status + "]";
	}

	}
