package com.bionische.biotech.paymenthistory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetLabPaymentDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="lab_app_id")
	private int labAppId;
 
 
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="lab_id")
	private int labId;
	
	
	@Column(name="lab_name")
	private String labName;
	 
	@Column(name="amount_type")
	private int amountType;
	
	@Column(name="payment_status")
	private int paymentStatus;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="discount")
	private float discount;
	
	@Column(name="total_amount")
	private float totalAmount;
 
	@Column(name="paid_amount")
	private float paidAmount;
	
	@Column(name="txn_id")
	private String txnId;
	
	@Column(name="order_id")
	private String orderId;
	

	@Column(name="payment_date")
	private String paymentDate;


	public int getLabAppId() {
		return labAppId;
	}


	public void setLabAppId(int labAppId) {
		this.labAppId = labAppId;
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


	public int getLabId() {
		return labId;
	}


	public void setLabId(int labId) {
		this.labId = labId;
	}


	public String getLabName() {
		return labName;
	}


	public void setLabName(String labName) {
		this.labName = labName;
	}


	public int getAmountType() {
		return amountType;
	}


	public void setAmountType(int amountType) {
		this.amountType = amountType;
	}


	public int getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public float getAmount() {
		return amount;
	}


	public void setAmount(float amount) {
		this.amount = amount;
	}


	public float getDiscount() {
		return discount;
	}


	public void setDiscount(float discount) {
		this.discount = discount;
	}


	public float getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
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


	public float getPaidAmount() {
		return paidAmount;
	}


	public void setPaidAmount(float paidAmount) {
		this.paidAmount = paidAmount;
	}


	@Override
	public String toString() {
		return "GetLabPaymentDetails [labAppId=" + labAppId + ", patientId=" + patientId + ", patientName="
				+ patientName + ", labId=" + labId + ", labName=" + labName + ", amountType=" + amountType
				+ ", paymentStatus=" + paymentStatus + ", amount=" + amount + ", discount=" + discount
				+ ", totalAmount=" + totalAmount + ", paidAmount=" + paidAmount + ", txnId=" + txnId + ", orderId="
				+ orderId + ", paymentDate=" + paymentDate + "]";
	}
 
 
}
