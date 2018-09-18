package com.bionische.biotech.yoga.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event_registration")

public class EventRegistration {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="event_reg_id")
	private int eventRegId;
	
	@Column(name="patient_id")
    private String patientId;
	
	
	@Column(name="contact")
    private String contact;
	
	@Column(name="event_id")
    private int eventId;
	
	@Column(name="int_1")
    private int int1;

	@Column(name="string1")
   private String string1;

	@Column(name="email")
   private String email;
	
	@Column(name="message")
	private String message;
	
	@Column(name="del_status")
   private int  delStatus;

	public int getEventRegId() {
		return eventRegId;
	}

	public void setEventRegId(int eventRegId) {
		this.eventRegId = eventRegId;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getInt1() {
		return int1;
	}

	public void setInt1(int int1) {
		this.int1 = int1;
	}

	public String getString1() {
		return string1;
	}

	public void setString1(String string1) {
		this.string1 = string1;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "EventRegistration [eventRegId=" + eventRegId + ", patientId=" + patientId + ", eventId=" + eventId
				+ ", contact=" + contact + ", int1=" + int1 + ", string1=" + string1 + ", email=" + email + ", message="
				+ message + ", delStatus=" + delStatus + "]";
	}

	
	
	
	
}
