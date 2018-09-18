package com.bionische.biotech.bloodbank.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="blood_available")


public class BloodAvailableDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="available_id")
	private int availableId;
	
	@Column(name="bloodbank_id")
   private int bloodBankId;
	
	@Column(name="date")     
   private String date;
	
	
	@Column(name="blood_group")
	private String bloodGroup;

   @Column(name="int_1")
   private int int1;
			
   	@Column(name="int_2")
private int int2;
	
	
	@Column(name="string1")
private String String1;
	
	@Column(name="string2")
private String String2;
	
	@Column(name="del_status")
private int delstatus;
	public int getAvailableId() {
		return availableId;
	}

	public void setAvailableId(int availableId) {
		this.availableId = availableId;
	}

	public int getBloodBankId() {
		return bloodBankId;
	}

	public void setBloodBankId(int bloodBankId) {
		this.bloodBankId = bloodBankId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
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
		return String1;
	}

	public void setString1(String string1) {
		String1 = string1;
	}

	public String getString2() {
		return String2;
	}

	public void setString2(String string2) {
		String2 = string2;
	}

	public int getDelstatus() {
		return delstatus;
	}

	public void setDelstatus(int delstatus) {
		this.delstatus = delstatus;
	}

	@Override
	public String toString() {
		return "BloodAvailableDetails [availableId=" + availableId + ", bloodBankId=" + bloodBankId + ", date=" + date
				+ ", bloodGroup=" + bloodGroup + ", int1=" + int1 + ", int2=" + int2 + ", String1=" + String1
				+ ", String2=" + String2 + ", delstatus=" + delstatus + "]";
	}

	
	
	
	



}
