package com.bionische.biotech.history.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="major_dieses")

public class MajorDiesesDetails {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="major_dieses_id")	
private int diesesId;

@Column(name="dieses_name")
private String diesesName; 


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

public int getDiesesId() {
	return diesesId;
}
public void setDiesesId(int diesesId) {
	this.diesesId = diesesId;
}
public String getDiesesName() {
	return diesesName;
}
public void setDiesesName(String diesesName) {
	this.diesesName = diesesName;
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
	return "MajorDiesesDetails [diesesId=" + diesesId + ", diesesName=" + diesesName + ", delStatus=" + delStatus
			+ ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + "]";
}
}
