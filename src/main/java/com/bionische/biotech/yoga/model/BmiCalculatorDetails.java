package com.bionische.biotech.yoga.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bmi_calci")

public class BmiCalculatorDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="bmi_id")
	private int bmiId;
	
	@Column(name="bmi")
	private float bmi;
	
	@Column(name="message")
	private String message;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="patient_id")
	private int patientId;

	public int getBmiId() {
		return bmiId;
	}

	public void setBmiId(int bmiId) {
		this.bmiId = bmiId;
	}

	public float getBmi() {
		return bmi;
	}

	public void setBmi(float bmi) {
		this.bmi = bmi;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Override
	public String toString() {
		return "BmiCalculatorDetails [bmiId=" + bmiId + ", bmi=" + bmi + ", "
				+ (message != null ? "message=" + message + ", " : "") + (date != null ? "date=" + date + ", " : "")
				+ (time != null ? "time=" + time + ", " : "") + "patientId=" + patientId + "]";
	}

	}
