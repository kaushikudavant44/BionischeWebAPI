package com.bionische.biotech.paymenthistory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class GetPharmacyPaymentDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="medical_request_id")
	private int requestToMedicalId;
	
	@Column(name="meet_id")
	private int meetId;
	
	@Column(name = "order_date")
	private String orderDate;
	
	@Column(name="medical_id")
	private int medicalId;
	
	@Column(name="patient_id")
	private int patientId;
	
	
	@Column(name="patient_name")
	private String patientName;

	
	
	@Column(name="medical_name")
	private String medicalName;
	 
	@Column(name="delivery_type")
	private int deliveryType;
	
	@Column(name="total_amt")
	private float totalAmt;
	
	@Column(name="payment_status")
	private int paymentStatus;
	
	@Column(name="txn_id")
	private String txnId;

	@Column(name="order_id")
	private String orderId;

	@Column(name="payment_date")
	private String paymentDate;

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

	 

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getMedicalName() {
		return medicalName;
	}

	public void setMedicalName(String medicalName) {
		this.medicalName = medicalName;
	}

	public int getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(int deliveryType) {
		this.deliveryType = deliveryType;
	}

	public float getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(float totalAmt) {
		this.totalAmt = totalAmt;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "GetPharmacyPaymentDetails [requestToMedicalId=" + requestToMedicalId + ", meetId=" + meetId
				+ ", orderDate=" + orderDate + ", medicalId=" + medicalId + ", patientId=" + patientId
				+ ", patientName=" + patientName + ", medicalName=" + medicalName + ", deliveryType=" + deliveryType
				+ ", totalAmt=" + totalAmt + ", paymentStatus=" + paymentStatus + ", txnId=" + txnId + ", orderId="
				+ orderId + ", paymentDate=" + paymentDate + "]";
	}
	
	
}
