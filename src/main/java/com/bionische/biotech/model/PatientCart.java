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
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="patient_cart")
@EntityListeners(AuditingEntityListener.class)
public class PatientCart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="date_time")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateTime;
	
	@Column(name="meet_id")
	private int meetId;
	
	@Column(name="status")
	private int status;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="string1")
	private String string1;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getMeetId() {
		return meetId;
	}

	public void setMeetId(int meetId) {
		this.meetId = meetId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	@Override
	public String toString() {
		return "PatientCart [cartId=" + cartId + ", patientId=" + patientId + ", dateTime=" + dateTime + ", meetId="
				+ meetId + ", status=" + status + ", int1=" + int1 + ", string1=" + string1 + "]";
	}
	
	
	
	

}
