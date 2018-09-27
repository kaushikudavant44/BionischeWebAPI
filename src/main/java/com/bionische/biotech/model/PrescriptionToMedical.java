package com.bionische.biotech.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name="doctor_appointment")
@EntityListeners(AuditingEntityListener.class)

public class PrescriptionToMedical {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="medical_request_id")
	private int patientRequestToMedicalId;
	
	@Column(name="meet_id")
	private int meetId;
	
	@Column(name = "order_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date orderDate;
	
	/** Last modified date */
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date")
	private Date lastModifiedDate;
	
	@Column(name="medical_id")
	private int medicalId;
	
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
	
	@Column(name="payment_status")
	private int paymentStatus;
	
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
	
	@Column(name="address")
	private String address;
	
	
}
