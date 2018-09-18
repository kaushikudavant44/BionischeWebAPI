package com.bionische.biotech.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lab_details")

public class HospitalRegDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="hospital_id")
private int hospitalId;
	
@Column(name="hospital_name")
private String hospitalName;

@Column(name="hospital_ownername")
private String hospitalOwnerName;

@Column(name="hospital_cityname")
private String hospitalCityName;

@Column(name="hospital_cityid")
private int hospitalCityId;

@Column(name="type")
private int Type;

@Column(name="hospital_address")
private String hospitalAddress;

@Column(name="hospitalcontact_1")
private int hospitalContact1;

@Column(name="hospitalcontact_2")
private int hospitalContact2;

@Column(name="hospital_state")
private String hospitalState;

@Column(name="hospital_country")
private String hospitalCountry;

@Column(name="hospitalemail_id")
private String hospitalEmailId;

@Column(name="int_1")
private int int1;

@Column(name="int_2")
private int int2;

@Column(name="string1")
private String string1;

@Column(name="string2")
private String string2;

@Column(name="del_status")
private int delstatus;

public int getHospitalId() {
	return hospitalId;
}
public void setHospitalId(int hospitalId) {
	this.hospitalId = hospitalId;
}
public String getHospitalName() {
	return hospitalName;
}
public void setHospitalName(String hospitalName) {
	this.hospitalName = hospitalName;
}
public String getHospitalOwnerName() {
	return hospitalOwnerName;
}
public void setHospitalOwnerName(String hospitalOwnerName) {
	this.hospitalOwnerName = hospitalOwnerName;
}
public String getHospitalCityName() {
	return hospitalCityName;
}
public void setHospitalCityName(String hospitalCityName) {
	this.hospitalCityName = hospitalCityName;
}
public int getHospitalCityId() {
	return hospitalCityId;
}
public void setHospitalCityId(int hospitalCityId) {
	this.hospitalCityId = hospitalCityId;
}
public int getType() {
	return Type;
}
public void setType(int type) {
	Type = type;
}
public String getHospitalAddress() {
	return hospitalAddress;
}
public void setHospitalAddress(String hospitalAddress) {
	this.hospitalAddress = hospitalAddress;
}
public int getHospitalContact1() {
	return hospitalContact1;
}
public void setHospitalContact1(int hospitalContact1) {
	this.hospitalContact1 = hospitalContact1;
}
public int getHospitalContact2() {
	return hospitalContact2;
}
public void setHospitalContact2(int hospitalContact2) {
	this.hospitalContact2 = hospitalContact2;
}
public String getHospitalState() {
	return hospitalState;
}
public void setHospitalState(String hospitalState) {
	this.hospitalState = hospitalState;
}
public String getHospitalCountry() {
	return hospitalCountry;
}
public void setHospitalCountry(String hospitalCountry) {
	this.hospitalCountry = hospitalCountry;
}
public String getHospitalEmailId() {
	return hospitalEmailId;
}
public void setHospitalEmailId(String hospitalEmailId) {
	this.hospitalEmailId = hospitalEmailId;
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
public int getDelstatus() {
	return delstatus;
}
public void setDelstatus(int delstatus) {
	this.delstatus = delstatus;
}
@Override
public String toString() {
	return "HospitalRegDetails [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalOwnerName="
			+ hospitalOwnerName + ", hospCityName=" + hospitalCityName + ", hospCityId=" + hospitalCityId + ", Type=" + Type
			+ ", hospitalAddress=" + hospitalAddress + ", hospitalContact1=" + hospitalContact1 + ", hospitalContact2="
			+ hospitalContact2 + ", hospitalState=" + hospitalState + ", hospitalCountry=" + hospitalCountry
			+ ", hospitalEmailId=" + hospitalEmailId + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1
			+ ", string2=" + string2 + ", delstatus=" + delstatus + "]";
}






}
