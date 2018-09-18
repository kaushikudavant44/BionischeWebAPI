package com.bionische.biotech.model;

import java.util.List;

public class GetCompletedPrescription {
	
private int patientRequestToMedicalId;
	
	private String patientName;
	
	private String hospitalName;
	
	private int meetId;
	
	private String date;
	
	private String time;
	
	private String doctorName;
	
	private int medicalId;
	
	private int int1;
	
	private float totalBill;
	
	private int int2;
	
	private String string1;
	
	private String string2;
	
	private int delStatus;
	
	private int status;
	
	private int patientId;
	
	private int doctorId;
	
	private int deliveryType;
	
	private int pincode;
	
	private String patientContact;
	
	private String city;
	
	private String landMark;
	
	private String address;
	
	private String medicalName;
	
	

	public String getMedicalName() {
		return medicalName;
	}

	public void setMedicalName(String medicalName) {
		this.medicalName = medicalName;
	}

	public float getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(float totalBill) {
		this.totalBill = totalBill;
	}

	List<GetPrescriptionWithBill> getPrescriptionWithBill;

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

	public int getPatientRequestToMedicalId() {
		return patientRequestToMedicalId;
	}

	public void setPatientRequestToMedicalId(int patientRequestToMedicalId) {
		this.patientRequestToMedicalId = patientRequestToMedicalId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	
	
	
	
	
	
	

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	
	public int getMeetId() {
		return meetId;
	}

	public void setMeetId(int meetId) {
		this.meetId = meetId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getMedicalId() {
		return medicalId;
	}

	public void setMedicalId(int medicalId) {
		this.medicalId = medicalId;
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

	public int getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(int deliveryType) {
		this.deliveryType = deliveryType;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<GetPrescriptionWithBill> getGetPrescriptionWithBill() {
		return getPrescriptionWithBill;
	}

	public void setGetPrescriptionWithBill(List<GetPrescriptionWithBill> getPrescriptionWithBill) {
		this.getPrescriptionWithBill = getPrescriptionWithBill;
	}

	@Override
	public String toString() {
		return "GetCompletedPrescription [patientRequestToMedicalId=" + patientRequestToMedicalId + ", patientName="
				+ patientName + ", hospitalName=" + hospitalName + ", meetId=" + meetId + ", date=" + date + ", time="
				+ time + ", doctorName=" + doctorName + ", medicalId=" + medicalId + ", int1=" + int1 + ", totalBill="
				+ totalBill + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + ", delStatus="
				+ delStatus + ", status=" + status + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", deliveryType=" + deliveryType + ", pincode=" + pincode + ", patientContact=" + patientContact
				+ ", city=" + city + ", landMark=" + landMark + ", address=" + address + ", getPrescriptionWithBill="
				+ getPrescriptionWithBill + "]";
	}

	
	
	
}
