package com.bionische.biotech.patientpasthistory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="patient_treatement_history")

public class PatientTreatementHistory {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="treatement_history_id")
	private int treatementHistoryId;
	@Column(name="patient_id")
	private int patientId;
	@Column(name="treatment_received",nullable = true)
	private  String treatmentReceived;
	@Column(name="allergy_reactions",nullable = true)
	private String allergyReactions;
	@Column(name="surgical_intervention",nullable = true)
	private String surgicalIntervention;
	@Column(name="use_oral_contraceptives",nullable = true)
	private String useOralContraceptives;
	@Column(name="blood_transfusion",nullable = true)
	private String bloodTransfusion;
	@Column(name="intake_nsaid",nullable = true)
	private String intakeNsaid;
	@Column(name="regular_use_oral_contraceptives",nullable = true)
	private String regularUsezoralContraceptives;
	@Column(name="string1",nullable = true)
	private String String1;
	@Column(name="string2",nullable = true)
	private String string2;
	@Column(name="string3",nullable = true)
	private String string3;
	
	public int gettreatementhistoryId() {
		return treatementHistoryId;
	}
	public void settreatementHistoryId(int treatementHistoryId) {
		this.treatementHistoryId = treatementHistoryId;
	}
	public int getpatientId() {
		return patientId;
	}
	public void setpatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getTreatmentReceived() {
		return treatmentReceived;
	}
	public void setTreatmentReceived(String treatmentReceived) {
		this.treatmentReceived = treatmentReceived;
	}
	public String getAllergyReactions() {
		return allergyReactions;
	}
	public void setAllergyReactions(String allergyReactions) {
		this.allergyReactions = allergyReactions;
	}
	public String getSurgicalIntervention() {
		return surgicalIntervention;
	}
	public void setSurgicalIntervention(String surgicalIntervention) {
		this.surgicalIntervention = surgicalIntervention;
	}
	public String getUseOralContraceptives() {
		return useOralContraceptives;
	}
	public void setUseOralContraceptives(String useOralContraceptives) {
		this.useOralContraceptives = useOralContraceptives;
	}
	public String getBloodTransfusion() {
		return bloodTransfusion;
	}
	public void setBloodTransfusion(String bloodTransfusion) {
		this.bloodTransfusion = bloodTransfusion;
	}
	public String getIntakeNsaid() {
		return intakeNsaid;
	}
	public void setIntakeNsaid(String intakeNsaid) {
		this.intakeNsaid = intakeNsaid;
	}
	public String getRegularUsezoralContraceptives() {
		return regularUsezoralContraceptives;
	}
	public void setRegularUsezoralContraceptives(String regularUsezoralContraceptives) {
		this.regularUsezoralContraceptives = regularUsezoralContraceptives;
	}
	public String getString1() {
		return String1;
	}
	public void setString1(String string1) {
		String1 = string1;
	}
	public String getString2() {
		return string2;
	}
	public void setString2(String string2) {
		this.string2 = string2;
	}
	public String getString3() {
		return string3;
	}
	public void setString3(String string3) {
		this.string3 = string3;
	}
	@Override
	public String toString() {
		return "PatientTreatementHistory [treatementHistoryId=" + treatementHistoryId + ", patientId=" + patientId
				+ ", treatmentReceived=" + treatmentReceived + ", allergyReactions=" + allergyReactions
				+ ", surgicalIntervention=" + surgicalIntervention + ", useOralContraceptives=" + useOralContraceptives
				+ ", bloodTransfusion=" + bloodTransfusion + ", intakeNsaid=" + intakeNsaid
				+ ", regularUsezoralContraceptives=" + regularUsezoralContraceptives + ", String1=" + String1
				+ ", string2=" + string2 + ", string3=" + string3 + "]";
	}
	
	
}
