package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;


@Entity
@Table(name="video_calldetails")
public class DoctorVideo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
    private int id;
	@Column(name="doctorid")
	private int doctorId;
	@Column(name="emailid")
	private String emailId;
	
	@Column(name="patientid")
	private int patientId;
	
	@Column(name="status")
	private int status;
	@Column(name="datetime")
	private String datetime; 
	@Column(name="string1")
	private String string1;
	@Column(name="string2")
	private String string2;
	@Column(name="int_1")
	private int int1;
	@Column(name="int_2")
	private int int2;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the doctorId
	 */
	public int getDoctorId() {
		return doctorId;
	}
	/**
	 * @param doctorId the doctorId to set
	 */
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the patientId
	 */
	public int getPatientId() {
		return patientId;
	}
	/**
	 * @param patientId the patientId to set
	 */
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
	/**
	 * @return the datetime
	 */
	public String getDatetime() {
		return DateConverter.convertToDMY(datetime);
	}
	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	/**
	 * @return the string1
	 */
	public String getString1() {
		return string1;
	}
	/**
	 * @param string1 the string1 to set
	 */
	public void setString1(String string1) {
		this.string1 = string1;
	}
	/**
	 * @return the string2
	 */
	public String getString2() {
		return string2;
	}
	/**
	 * @param string2 the string2 to set
	 */
	public void setString2(String string2) {
		this.string2 = string2;
	}
	/**
	 * @return the int1
	 */
	public int getInt1() {
		return int1;
	}
	/**
	 * @param int1 the int1 to set
	 */
	public void setInt1(int int1) {
		this.int1 = int1;
	}
	/**
	 * @return the int2
	 */
	public int getInt2() {
		return int2;
	}
	/**
	 * @param int2 the int2 to set
	 */
	public void setInt2(int int2) {
		this.int2 = int2;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DoctorVideo [id=" + id + ", doctorId=" + doctorId + ", emailId=" + emailId + ", patientId=" + patientId
				+ ", status=" + status + ", datetime=" + datetime + ", string1=" + string1 + ", string2=" + string2
				+ ", int1=" + int1 + ", int2=" + int2 + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
