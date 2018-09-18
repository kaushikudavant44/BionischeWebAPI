package com.bionische.biotech.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity

public class PrescriptionToMedical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="medical_request_id")
	private int patientRequestToMedicalId;
	
	@Column(name="patient_name")
	private String patientName;
	
	@Column(name="hospital_name")
	private String hospitalName;
	
	@Column(name="meet_id")
	private int meetId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="doctor_name")
	private String doctorName;
	
	@Column(name="medical_id")
	private int medicalId;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="int_2")
	private int int2;
	
	@Column(name="string_1")
	private String string1;
	
	@Column(name="string_2")
	private String string2;
	
	@Column(name="del_status")
	private int delStatus;

	@Column(name="status")
	private int status;
	
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="delivery_type")
	private int deliveryType;
	
	@Column(name="pincode")
	private int pincode;
	
	@Column(name="patient_contact")
	private String patientContact;
	
	@Column(name="city")
	private String city;
	
	@Column(name="land_mark")
	private String landMark;
	
	@Column(name="address")
	private String address;
	
	@Column(name="medical_name")
	private String medicalName;
	
	@Transient
	List<PrescriptionDetails> prescriptionDetails;
	
	

	public String getMedicalName() {
		return medicalName;
	}

	public void setMedicalName(String medicalName) {
		this.medicalName = medicalName;
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

	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<PrescriptionDetails> getPrescriptionDetails() {
		return prescriptionDetails;
	}

	public void setPrescriptionDetails(List<PrescriptionDetails> prescriptionDetails) {
		this.prescriptionDetails = prescriptionDetails;
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

	@Override
	public String toString() {
		return "PrescriptionToMedical [patientRequestToMedicalId=" + patientRequestToMedicalId + ", patientName="
				+ patientName + ", hospitalName=" + hospitalName + ", meetId=" + meetId + ", date=" + date + ", time="
				+ time + ", doctorName=" + doctorName + ", medicalId=" + medicalId + ", int1=" + int1 + ", int2=" + int2
				+ ", string1=" + string1 + ", string2=" + string2 + ", delStatus=" + delStatus + ", status=" + status
				+ ", patientId=" + patientId + ", doctorId=" + doctorId + ", deliveryType=" + deliveryType
				+ ", pincode=" + pincode + ", patientContact=" + patientContact + ", city=" + city + ", landMark="
				+ landMark + ", address=" + address + ", medicalName=" + medicalName + ", prescriptionDetails="
				+ prescriptionDetails + "]";
	}

	

	
}
