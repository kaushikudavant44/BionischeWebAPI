package com.bionische.biotech.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bionische.biotech.Common.DateConverter;
@Entity
public class GetPharmacyPrescriptionPaymentForReceipt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="appoint_id")
	private int appointId;
	
	@Column(name="medical_id")
	private int medicalId;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="txn_id")
	private String txnId;
	
	@Column(name = "payment_date")
	private String paymentDate;
	
	@Column(name="paid_by_wallet")
	private float paidByWallet;
	
	@Column(name="paid_by_bank")
	private float paidByBank;
	
	@Column(name="is_wallet_payment")
	private int isWalletPayment;
	
	
	
	@Column(name="patient_id")
	private int patientId;

	public int getAppointId() {
		return appointId;
	}

	public void setAppointId(int appointId) {
		this.appointId = appointId;
	}

	 
	public int getMedicalId() {
		return medicalId;
	}

	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
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

	public String getPaymentDate() {
		return DateConverter.convertToDMY(paymentDate);
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public float getPaidByWallet() {
		return paidByWallet;
	}

	public void setPaidByWallet(float paidByWallet) {
		this.paidByWallet = paidByWallet;
	}

	public float getPaidByBank() {
		return paidByBank;
	}

	public void setPaidByBank(float paidByBank) {
		this.paidByBank = paidByBank;
	}

	public int getIsWalletPayment() {
		return isWalletPayment;
	}

	public void setIsWalletPayment(int isWalletPayment) {
		this.isWalletPayment = isWalletPayment;
	}

	@Override
	public String toString() {
		return "GetPharmacyPrescriptionPaymentForReceipt [appointId=" + appointId + ", medicalId=" + medicalId
				+ ", amount=" + amount + ", txnId=" + txnId + ", paymentDate=" + paymentDate + ", paidByWallet="
				+ paidByWallet + ", paidByBank=" + paidByBank + ", isWalletPayment=" + isWalletPayment + ", patientId="
				+ patientId + "]";
	}

	 
	 
	
}
