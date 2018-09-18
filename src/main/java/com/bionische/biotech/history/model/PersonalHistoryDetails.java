package com.bionische.biotech.history.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personal_history_details ")

public class PersonalHistoryDetails {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="parsonal_history_id")	
private int personalHistoryId;

@Column(name="patient_id")	
private int patientId;

@Column(name="education")	
private String education;
 
@Column(name="marital_status")	
private String maritalStatus;

@Column(name="currently_working")	
private String currentlyWorking;

@Column(name="received_disablity")	
private int receivedDisablity;

@Column(name="legal_problem")	
private String legalProblem;

@Column(name="religion")	
private String religion;

@Column(name="del_status")	
private int delStatus;

@Column(name="int_1")
private int int1;

@Column(name="int_2")
private int int2;

@Column(name="string1")
private String string1;

@Column(name="string2")
private String string2;


public int getPersonHistoryId() {
	return personalHistoryId;
}
public void setPersonalHistoryId(int personalHistoryId) {
	this.personalHistoryId = personalHistoryId;
}
public int getPatientId() {
	return patientId;
}
public void setPatientId(int patientId) {
	this.patientId = patientId;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
public String getMaritalStatus() {
	return maritalStatus;
}
public void setMaritalStatus(String maritalStatus) {
	this.maritalStatus = maritalStatus;
}
public String getCurrentlyWorking() {
	return currentlyWorking;
}
public void setCurrentlyWorking(String currentlyWorking) {
	this.currentlyWorking = currentlyWorking;
}
public int getReceivedDisablity() {
	return receivedDisablity;
}
public void setReceivedDisablity(int receivedDisablity) {
	this.receivedDisablity = receivedDisablity;
}
public String getLegalProblem() {
	return legalProblem;
}
public void setLegalProblem(String legalProblem) {
	this.legalProblem = legalProblem;
}
public String getReligion() {
	return religion;
}
public void setReligion(String religion) {
	this.religion = religion;
}
public int getDelStatus() {
	return delStatus;
}
public void setDelStatus(int delStatus) {
	this.delStatus = delStatus;
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
@Override
public String toString() {
	return "PersonHistoryDetails [personHistoryId=" + personalHistoryId + ", patientId=" + patientId + ", education="
			+ education + ", maritalStatus=" + maritalStatus + ", currentlyWorking=" + currentlyWorking
			+ ", receivedDisablity=" + receivedDisablity + ", legalProblem=" + legalProblem + ", religion=" + religion
			+ ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2="
			+ string2 + "]";
}
}
