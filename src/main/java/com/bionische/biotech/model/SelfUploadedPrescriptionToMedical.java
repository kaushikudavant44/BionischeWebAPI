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
@Table(name="self_uploaded_prescription_to_medical")
@EntityListeners(AuditingEntityListener.class)
public class SelfUploadedPrescriptionToMedical {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="medical_req_id")
	private int medicalRequestId;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="medical_id")
	private int medicalId;
	
	@Column(name="address")
	private String address;
	
	@Column(name="pincode")
	private int pincode;
	
	@Column(name="total_amt")
	private float totalAmt;
	
	@Column(name="payment_status")
	private int paymentStatus;
	
	@Column(name="payment_date")
	private String paymentDate;
	
	@Column(name="payment_type")
	private int paymentType;
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	@Column(name="order_date")
	private Date orderDate;
	
	@Column(name="order_id")
	private String orderId;
	
	@Column(name="txn_id")
	private String txnId;
	
	@Column(name="delivery_type")
	private int deliveryType;
	
	@Column(name="is_wallet_payment")
	private int isWalletPayment;
	
	@Column(name="paid_by_wallet")
	private float paidByWallet;
	
	@Column(name="paid_by_bank")
	private float paidByBank;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="patient_contact")
	private String patientContact;
	
	@Column(name="prescription_name")
	private String prescriptionName;
	
	@Column(name="status")
	private int status;
	
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getMedicalRequestId() {
		return medicalRequestId;
	}

	public void setMedicalRequestId(int medicalRequestId) {
		this.medicalRequestId = medicalRequestId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getMedicalId() {
		return medicalId;
	}

	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
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

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(int paymentType) {
		this.paymentType = paymentType;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTxnId() {
		return txnId;
	}

	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}

	public int getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(int deliveryType) {
		this.deliveryType = deliveryType;
	}

	public int getIsWalletPayment() {
		return isWalletPayment;
	}

	public void setIsWalletPayment(int isWalletPayment) {
		this.isWalletPayment = isWalletPayment;
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public String getPatientContact() {
		return patientContact;
	}

	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}

	public String getPrescriptionName() {
		return prescriptionName;
	}

	public void setPrescriptionName(String prescriptionName) {
		this.prescriptionName = prescriptionName;
	}

	@Override
	public String toString() {
		return "SelfUploadedPrescriptionToMedical [medicalRequestId=" + medicalRequestId + ", patientId=" + patientId
				+ ", medicalId=" + medicalId + ", address=" + address + ", pincode=" + pincode + ", totalAmt="
				+ totalAmt + ", paymentStatus=" + paymentStatus + ", paymentDate=" + paymentDate + ", paymentType="
				+ paymentType + ", orderDate=" + orderDate + ", orderId=" + orderId + ", txnId=" + txnId
				+ ", deliveryType=" + deliveryType + ", isWalletPayment=" + isWalletPayment + ", paidByWallet="
				+ paidByWallet + ", paidByBank=" + paidByBank + ", delStatus=" + delStatus + ", patientContact="
				+ patientContact + ", prescriptionName=" + prescriptionName + ", status=" + status + "]";
	}

	
	
	
	
	
}
