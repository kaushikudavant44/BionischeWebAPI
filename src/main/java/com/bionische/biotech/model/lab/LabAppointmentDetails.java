package com.bionische.biotech.model.lab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.google.firebase.internal.NonNull;

@Entity
@Table(name="t_lab_appointment_details")
public class LabAppointmentDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int labAppId;
	
	@NotBlank
    private String testIdList;
	
	@NotNull
	private int labId;
	
	@NotNull
	private int patientId;
	
	@NotBlank
	private String labAppDate;
	
	
	@NotNull
	private int timeId;
	
	@NotNull
	private int delStatus;
	
	@NotNull
	private int status;
	
	@NotNull
	private int amountType;
	
	@NotNull
	private float amount;
	
	@NotNull
	private int paymentStatus;
	
	private float discount;
	
	@NotNull
	private float totalAmount;
	
	private String txnId;
	
	private float paidAmount;
	
	private String orderId;
	
	private String paymentDate;
	
	private int refference;
	
	private int doctorId;

	public int getLabAppId() {
		return labAppId;
	}

	public void setLabAppId(int labAppId) {
		this.labAppId = labAppId;
	}

	 

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getLabAppDate() {
		return labAppDate;
	}

	public void setLabAppDate(String labAppDate) {
		this.labAppDate = labAppDate;
	}

	public int getTimeId() {
		return timeId;
	}

	public void setTimeId(int timeId) {
		this.timeId = timeId;
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

	public int getAmountType() {
		return amountType;
	}

	public void setAmountType(int amountType) {
		this.amountType = amountType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
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

	public float getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(float paidAmount) {
		this.paidAmount = paidAmount;
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

	public String getTestIdList() {
		return testIdList;
	}

	public void setTestIdList(String testIdList) {
		this.testIdList = testIdList;
	}

	public int getRefference() {
		return refference;
	}

	public void setRefference(int refference) {
		this.refference = refference;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	@Override
	public String toString() {
		return "LabAppointmentDetails [labAppId=" + labAppId + ", testIdList=" + testIdList + ", labId=" + labId
				+ ", patientId=" + patientId + ", labAppDate=" + labAppDate + ", timeId=" + timeId + ", delStatus="
				+ delStatus + ", status=" + status + ", amountType=" + amountType + ", amount=" + amount
				+ ", paymentStatus=" + paymentStatus + ", discount=" + discount + ", totalAmount=" + totalAmount
				+ ", txnId=" + txnId + ", paidAmount=" + paidAmount + ", orderId=" + orderId + ", paymentDate="
				+ paymentDate + ", refference=" + refference + ", doctorId=" + doctorId + "]";
	}
 
}
