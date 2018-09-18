package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GetPatientBornReport {

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="baby_report_id")
	private int babyReportId;
	
	
	@Column(name="mother_name")
	private String motherName;
	
	@Column(name="head_circumference")
	private String headCircumference;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="sex")
	private String sex;

	@Column(name="birth_time")
	private String birthTime;
	
	@Column(name="length")
	private String length;
	
	
	@Column(name="birth_weight")
	private String birthWeight;
	
	
	@Column(name="blood_group")
	private String bloodGroup;
	
	@Column(name="delivery_type")
	private String deliveryType;
	 
	 
	@Column(name="family_id")
	private int familyId;
	
	 
	@Column(name="patient_id")
	private int patientId;
	
	@Column(name="doctor_id")
	private int doctorId;
	
	@Column(name="f_name")
	private String fName;
	
	@Column(name="l_name")
	private String lName;
	
	@Column(name="m_name")
	private String mName;
	
	@Column(name="spec_type")
	private String specType;
	
	@Column(name="spec_id")
	private int specId;
	
	@Column(name="del_status")
	private int delStatus;
	
	@Column(name="hospital_name")
	private String hospitalName;
	
	
	@Column(name="int_1")
	private int int1;
	
	
	@Column(name="int_2")
	private int int2;
	
	
	@Column(name="string1")
	private String string1;
	
	
	@Column(name="string2")
	private String string2;


	public int getBabyReportId() {
		return babyReportId;
	}


	public void setBabyReportId(int babyReportId) {
		this.babyReportId = babyReportId;
	}


	public String getMotherName() {
		return motherName;
	}


	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getBirthTime() {
		return birthTime;
	}


	public void setBirthTime(String birthTime) {
		this.birthTime = birthTime;
	}


	public String getLength() {
		return length;
	}


	public void setLength(String length) {
		this.length = length;
	}


	public String getBirthWeight() {
		return birthWeight;
	}


	public void setBirthWeight(String birthWeight) {
		this.birthWeight = birthWeight;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getDeliveryType() {
		return deliveryType;
	}


	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}


	public int getFamilyId() {
		return familyId;
	}


	public void setFamilyId(int familyId) {
		this.familyId = familyId;
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


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public String getmName() {
		return mName;
	}


	public void setmName(String mName) {
		this.mName = mName;
	}


	public String getSpecType() {
		return specType;
	}


	public void setSpecType(String specType) {
		this.specType = specType;
	}


	public int getSpecId() {
		return specId;
	}


	public void setSpecId(int specId) {
		this.specId = specId;
	}


	public int getDelStatus() {
		return delStatus;
	}


	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}


	public String getHospitalName() {
		return hospitalName;
	}


	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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


	public String getHeadCircumference() {
		return headCircumference;
	}


	public void setHeadCircumference(String headCircumference) {
		this.headCircumference = headCircumference;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	@Override
	public String toString() {
		return "GetPatientBornReport [babyReportId=" + babyReportId + ", motherName=" + motherName
				+ ", headCircumference=" + headCircumference + ", dob=" + dob + ", sex=" + sex + ", birthTime="
				+ birthTime + ", length=" + length + ", birthWeight=" + birthWeight + ", bloodGroup=" + bloodGroup
				+ ", deliveryType=" + deliveryType + ", familyId=" + familyId + ", patientId=" + patientId
				+ ", doctorId=" + doctorId + ", fName=" + fName + ", lName=" + lName + ", mName=" + mName
				+ ", specType=" + specType + ", specId=" + specId + ", delStatus=" + delStatus + ", hospitalName="
				+ hospitalName + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2
				+ "]";
	}


	 
 
 
	
}
