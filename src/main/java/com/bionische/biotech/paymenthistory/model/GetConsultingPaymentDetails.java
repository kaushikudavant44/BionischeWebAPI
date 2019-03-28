package com.bionische.biotech.paymenthistory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bionische.biotech.Common.DateConverter;

@Entity
public class GetConsultingPaymentDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="appoint_id")
	private int appointId;

	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="doctor_name")
	private String doctorName;
	

	@Column(name="patient_id")
	private int patientId;

	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="payment_status")
    private int paymentStatus;
	
	@Column(name="txn_id")
    private String txnId;

	@Column(name="order_id")
    private String orderId;
	

	@Column(name="amount")
    private float amount;
	

	@Column(name="payment_date")
    private String paymentDate;


	public int getAppointId() {
		return appointId;
	}


	public void setAppointId(int appointId) {
		this.appointId = appointId;
	}


	public int getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public String getPaymentDate() {
		return DateConverter.convertToDMY(paymentDate);
	}


	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}


	@Override
	public String toString() {
		return "GetConsultingPaymentDetails [appointId=" + appointId + ", doctorId=" + doctorId + ", doctorName="
				+ doctorName + ", patientId=" + patientId + ", patientName=" + patientName + ", paymentStatus="
				+ paymentStatus + ", txnId=" + txnId + ", orderId=" + orderId + ", amount=" + amount + ", paymentDate="
				+ paymentDate + "]";
	}
	
	
}
