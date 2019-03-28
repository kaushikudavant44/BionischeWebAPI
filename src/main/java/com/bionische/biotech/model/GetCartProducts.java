package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bionische.biotech.Common.DateConverter;

@Entity
public class GetCartProducts {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="doctor_id")
    private int doctorId;
	
	@Column(name="patient_id")
	private int patintId;
	
	@Column(name="meet_id")
	private int meetId;
	
	@Column(name="hospital_name")
	private String hospitalName;
	
	@Column(name="f_name")
	private String doctorName;
	
	@Column(name="date_time")
	private String cartDate;
	
	@Column(name="patient_problem")
	private String patientProblem;
	
	@Column(name="discussion")
	private String discussion;
	
	@Column(name="note")
	private String note;
	
	@Column(name="patient_name")
	private String patientName;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatintId() {
		return patintId;
	}

	public void setPatintId(int patintId) {
		this.patintId = patintId;
	}

	public int getMeetId() {
		return meetId;
	}

	public void setMeetId(int meetId) {
		this.meetId = meetId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getCartDate() {
		return DateConverter.convertToDMY(cartDate);
	}

	public void setCartDate(String cartDate) {
		this.cartDate = cartDate;
	}

	public String getPatientProblem() {
		return patientProblem;
	}

	public void setPatientProblem(String patientProblem) {
		this.patientProblem = patientProblem;
	}

	public String getDiscussion() {
		return discussion;
	}

	public void setDiscussion(String discussion) {
		this.discussion = discussion;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	
	@Override
	public String toString() {
		return "GetCartProducts [cartId=" + cartId + ", doctorId=" + doctorId + ", patintId=" + patintId + ", meetId="
				+ meetId + ", hospitalName=" + hospitalName + ", doctorName=" + doctorName + ", cartDate=" + cartDate
				+ ", patientProblem=" + patientProblem + ", discussion=" + discussion + ", note=" + note
				+ ", patientName=" + patientName + "]";
	}
	
	

}
