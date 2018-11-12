package com.bionische.biotech.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="doctor_certificate_details")
@EntityListeners(AuditingEntityListener.class)
public class DoctorCertificateDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cetrificate_id")
    private int cetrificateId;
	
	@Column(name="certificate")
    private String cetrificate;
	
	@Column(name="doctor_id")
    private int doctorId;
	
	@Column(name="string1")
    private String string1;
	
	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createDate;
	
	/** Last modified date */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	@Column(name="message")
    private String message;
	
	@Column(name="del_status")
    private int delStatus;
	
	@Column(name="int_1")
    private int int1;

	public int getCetrificateId() {
		return cetrificateId;
	}

	public void setCetrificateId(int cetrificateId) {
		this.cetrificateId = cetrificateId;
	}

	public String getCetrificate() {
		return cetrificate;
	}

	public void setCetrificate(String cetrificate) {
		this.cetrificate = cetrificate;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
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

	public Date getCreateDate() {
		return createDate;
	}

	 

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	 

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DoctorCertificateDetails [cetrificateId=" + cetrificateId + ", cetrificate=" + cetrificate
				+ ", doctorId=" + doctorId + ", string1=" + string1 + ", createDate=" + createDate
				+ ", lastModifiedDate=" + lastModifiedDate + ", message=" + message + ", delStatus=" + delStatus
				+ ", int1=" + int1 + "]";
	}

	 
	
}
