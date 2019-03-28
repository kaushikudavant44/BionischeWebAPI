package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bionische.biotech.Common.DateConverter;

@Entity
public class GetMedicalOrderDetails {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="medical_request_id")
	private int requestToMedicalId;
	
	@Column(name="meet_id")
	private int meetId;
	
	@Column(name="medical_id")
	private int medicalId;
	
	@Column(name="last_modified_date")
	private String lastModifiedDate;
	
	@Column(name="order_date")
	private String orderDate;
	
	@Column(name="medical_name")
	private String medicalName;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="doctor_contact")
	private String doctorContact;
	
	@Column(name="delivery_type")
	private int deliveryType;
	
	@Column(name="total_amt")
	private float totalAmt;
	
	@Column(name="pincode")
	private int pincode;
	
	@Column(name="patient_contact")
	private String patientContact;
	
	@Column(name="payment_status")
	private int paymentStatus;

	@Column(name="del_status")
	private int delStatus;

	@Column(name="status")
	private int status;
	
	@Column(name="address")
	private String address;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="payment_date")
	private String paymentDate;
	
	
	
	public String getPaymentDate() {
		return DateConverter.convertToDMY(paymentDate);
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

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

	public int getMedicalId() {
		return medicalId;
	}

	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
	}

	public String getLastModifiedDate() {
		return DateConverter.convertToDMY(lastModifiedDate);
	}

	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getOrderDate() {
		return DateConverter.convertToDMY(orderDate);
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getMedicalName() {
		return medicalName;
	}

	public void setMedicalName(String medicalName) {
		this.medicalName = medicalName;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	 

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	 

	 

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorContact() {
		return doctorContact;
	}

	public void setDoctorContact(String doctorContact) {
		this.doctorContact = doctorContact;
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

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getPatientContact() {
		return patientContact;
	}

	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}

	public int getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(int paymentStatus) {
		this.paymentStatus = paymentStatus;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "GetMedicalOrderDetails [requestToMedicalId=" + requestToMedicalId + ", meetId=" + meetId
				+ ", medicalId=" + medicalId + ", lastModifiedDate=" + lastModifiedDate + ", orderDate=" + orderDate
				+ ", medicalName=" + medicalName + ", patientId=" + patientId + ", patientName=" + patientName
				+ ", doctorId=" + doctorId + ", doctorName=" + doctorName + ", doctorContact=" + doctorContact
				+ ", deliveryType=" + deliveryType + ", totalAmt=" + totalAmt + ", pincode=" + pincode
				+ ", patientContact=" + patientContact + ", paymentStatus=" + paymentStatus + ", delStatus=" + delStatus
				+ ", status=" + status + ", address=" + address + ", email=" + email + ", contact=" + contact
				+ ", paymentDate=" + paymentDate + "]";
	}

	

	
	
	
}
