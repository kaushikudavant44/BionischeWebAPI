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
@Table(name="patient_notification")
@EntityListeners(AuditingEntityListener.class)
public class PatientNotification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="notification_id")
	private int notificationId;

	@Column(name="notification")
	String notification;
	
	@Column(name="status")
	int status;
	
	@Column(name="patient_id")
	int patientId;
	
	@Column(name="date_time")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	Date dateTime;
	
	@Column(name="int_1")
	int int1;
	
	@Column(name="string1")
	String string1;

	@Column(name="string2")
	String string2;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
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

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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

	public String getString2() {
		return string2;
	}

	public void setString2(String string2) {
		this.string2 = string2;
	}

	@Override
	public String toString() {
		return "PatientNotification [notificationId=" + notificationId + ", notification=" + notification + ", status="
				+ status + ", patientId=" + patientId + ", dateTime=" + dateTime + ", int1=" + int1 + ", string1="
				+ string1 + ", string2=" + string2 + "]";
	}

	
}
