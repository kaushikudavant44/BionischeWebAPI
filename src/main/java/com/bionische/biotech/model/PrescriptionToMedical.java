package com.bionische.biotech.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="prescription_to_medical")
@EntityListeners(AuditingEntityListener.class)

public class PrescriptionToMedical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="medical_request_id")
	private int requestToMedicalId;
	
	@Column(name="meet_id")
	private int meetId;
	
	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date orderDate;
	
	/** Last modified date */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	@Column(name="medical_id")
	private int medicalId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="delivery_type")
	private int deliveryType;
	
	@Column(name="total_amt")
	private float totalAmt;
	
	@Column(name="pincode")
	private int pincode;
	
	@Column(name="patient_contact")
	private String patientContact;
	
	@Column(name="payment_status")
	private int paymentStatus;
	
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

	@Column(name="status")
	private int status;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;

	
	
	public Date getOrderDate() {
		return orderDate;
	}

 

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

 

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
 

	public int getRequestToMedicalId() {
		return requestToMedicalId;
	}

	public void setRequestToMedicalId(int requestToMedicalId) {
		this.requestToMedicalId = requestToMedicalId;
	}

	public int getMeetId() {
		return meetId;
	}

	public void setMeetId(int meetId) {
		this.meetId = meetId;
	}

	public int getMedicalId() {
		return medicalId;
	}

	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(int deliveryType) {
		this.deliveryType = deliveryType;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPatientContact() {
		return patientContact;
	}

	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public float getTotalAmt() {
		return totalAmt;
	}



	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}



	@Override
	public String toString() {
		return "PrescriptionToMedical [requestToMedicalId=" + requestToMedicalId + ", meetId=" + meetId + ", orderDate="
				+ orderDate + ", lastModifiedDate=" + lastModifiedDate + ", medicalId=" + medicalId + ", patientId="
				+ patientId + ", doctorId=" + doctorId + ", deliveryType=" + deliveryType + ", totalAmt=" + totalAmt
				+ ", pincode=" + pincode + ", patientContact=" + patientContact + ", paymentStatus=" + paymentStatus
				+ ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + ", delStatus="
				+ delStatus + ", status=" + status + ", address=" + address + ", email=" + email + "]";
	}

	 
	
	
	
}
