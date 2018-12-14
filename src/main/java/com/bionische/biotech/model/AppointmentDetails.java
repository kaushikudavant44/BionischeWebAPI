package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="doctor_appointment")

public class AppointmentDetails {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="appoint_id")
	private int appointId;

	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="status")
	private int status;
	

	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="time")
	private int time;
	
	@Column(name="date")
	private String date;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;
	
	@Column(name="string1")
	private String string1;
	
	@Column(name="string2")
	private String string2;
	
	@Column(name="del_status")
    private int delStatus;
	
	@Column(name="hospital_id")
    private String hospitalId;
	
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
    
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
 
	 
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	 
	public String getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(String hospitalId) {
		this.hospitalId = hospitalId;
	}
	
	public int getAppointId() {
		return appointId;
	}
	public void setAppointId(int appointId) {
		this.appointId = appointId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
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
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	@Override
	public String toString() {
		return "AppointmentDetails [appointId=" + appointId + ", doctorId=" + doctorId + ", status=" + status
				+ ", patientId=" + patientId + ", time=" + time + ", date=" + date + ", int1=" + int1 + ", int2=" + int2
				+ ", string1=" + string1 + ", string2=" + string2 + ", delStatus=" + delStatus + ", hospitalId="
				+ hospitalId + ", paymentStatus=" + paymentStatus + ", txnId=" + txnId + ", orderId=" + orderId
				+ ", amount=" + amount + ", paymentDate=" + paymentDate + "]";
	}
	 
	  
	
 
}
