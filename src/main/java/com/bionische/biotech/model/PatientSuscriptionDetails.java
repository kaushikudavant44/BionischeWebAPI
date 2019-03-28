package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bionische.biotech.Common.DateConverter;


@Entity
@Table(name="t_patient_suscription_details")
public class PatientSuscriptionDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="suscription_id")
	private int suscriptionId;
	
	
	@Column(name="patient_id")
	private int patientId;
	
	
	@Column(name="package_id")
	private int packageId;
	
	@Column(name="status")
	private int status;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="txn_id")
	private String txnId;
	
	@Column(name="order_id")
	private String orderId;
	
	@Column(name="payment_date")
	private String paymentDate;
	
	@Column(name="offer_id")
	private int offerId;
	
	@Column(name="package_amt")
	private float packageAmt;

	public int getSuscriptionId() {
		return suscriptionId;
	}

	public void setSuscriptionId(int suscriptionId) {
		this.suscriptionId = suscriptionId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getPackageId() {
		return packageId;
	}

	public void setPackageId(int packageId) {
		this.packageId = packageId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
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
		return DateConverter.convertToDMY(paymentDate);
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public float getPackageAmt() {
		return packageAmt;
	}

	public void setPackageAmt(float packageAmt) {
		this.packageAmt = packageAmt;
	}

	@Override
	public String toString() {
		return "PatientSuscriptionDetails [suscriptionId=" + suscriptionId + ", patientId=" + patientId + ", packageId="
				+ packageId + ", status=" + status + ", amount=" + amount + ", txnId=" + txnId + ", orderId=" + orderId
				+ ", paymentDate=" + paymentDate + ", offerId=" + offerId + ", packageAmt=" + packageAmt + "]";
	}

	 
	
	
}
