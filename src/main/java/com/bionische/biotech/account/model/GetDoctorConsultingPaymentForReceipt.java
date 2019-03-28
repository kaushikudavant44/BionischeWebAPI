package com.bionische.biotech.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bionische.biotech.Common.DateConverter;
@Entity
public class GetDoctorConsultingPaymentForReceipt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="appoint_id")
	private int appointId;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="paid_by_bank_amount")
	private float paidByBankAmount;
	
	@Column(name="paid_by_wallet_amount")
	private float paidByWalletAmount;
	
	
	@Column(name="is_wallet_amount")
	private int isWalletAmount;
	
	@Column(name="txn_id")
	private String txnId;
	
	@Column(name = "payment_date")
	private String paymentDate;
	
	@Column(name="patient_id")
	private int patientId;

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

	public float getPaidByBankAmount() {
		return paidByBankAmount;
	}

	public void setPaidByBankAmount(float paidByBankAmount) {
		this.paidByBankAmount = paidByBankAmount;
	}

	public float getPaidByWalletAmount() {
		return paidByWalletAmount;
	}

	public void setPaidByWalletAmount(float paidByWalletAmount) {
		this.paidByWalletAmount = paidByWalletAmount;
	}

	public int getIsWalletAmount() {
		return isWalletAmount;
	}

	public void setIsWalletAmount(int isWalletAmount) {
		this.isWalletAmount = isWalletAmount;
	}

	@Override
	public String toString() {
		return "GetDoctorConsultingPaymentForReceipt [appointId=" + appointId + ", doctorId=" + doctorId + ", amount="
				+ amount + ", paidByBankAmount=" + paidByBankAmount + ", paidByWalletAmount=" + paidByWalletAmount
				+ ", isWalletAmount=" + isWalletAmount + ", txnId=" + txnId + ", paymentDate=" + paymentDate
				+ ", patientId=" + patientId + "]";
	}

	 
}
