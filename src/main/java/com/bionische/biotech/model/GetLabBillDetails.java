package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetLabBillDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="lab_app_id")
	private int id;
 

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
	private int status;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="discount")
	private float discount;
	
	@Column(name="paid_amount")
	private float totalAmount;
 
	
	@Column(name="txn_id")
	private String txnId;
	
	@Column(name="order_id")
	private String orderId;
	

	@Column(name="payment_date")
	private String paymentDate;
	
	@Column(name="test_id_list")
	private String testIdList;
	
	@Column(name="lab_test_name")
	private String labTestName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="address")
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTestIdList() {
		return testIdList;
	}

	public void setTestIdList(String testIdList) {
		this.testIdList = testIdList;
	}

	public String getLabTestName() {
		return labTestName;
	}

	public void setLabTestName(String labTestName) {
		this.labTestName = labTestName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "GetLabBillDetails [id=" + id + ", patientId=" + patientId + ", patientName=" + patientName + ", labId="
				+ labId + ", labName=" + labName + ", amountType=" + amountType + ", status=" + status + ", amount="
				+ amount + ", discount=" + discount + ", totalAmount=" + totalAmount + ", txnId=" + txnId + ", orderId="
				+ orderId + ", paymentDate=" + paymentDate + ", testIdList=" + testIdList + ", labTestName="
				+ labTestName + ", email=" + email + ", contact=" + contact + ", address=" + address + "]";
	}

	 
}
