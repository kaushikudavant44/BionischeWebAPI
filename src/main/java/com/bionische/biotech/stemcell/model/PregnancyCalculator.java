package com.bionische.biotech.stemcell.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="preganancy_calci")

public class PregnancyCalculator {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="pregnanacy_id")
	private int pregnancyId;
	
	
   @Column(name="to_firtility")
  private String toFirtilityDate;

   @Column(name="date")
   private String date;
   @Column(name="time")
   private String time;

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

@Column(name="firtility_date")
    private String firtilityDate;
	

	@Column(name="conceptiondate")
   private String conceptionDate;
	
	
	@Column(name="first_tri_date")
    private String firstTrimisterDate;
	
	
	@Column(name="second_tri_date")
private String secondTrimisterDate;
	
	
	@Column(name="due_date")
private String dueDate;
	
	
	@Column(name="int_1")
	private int int1;
	
	
	@Column(name="int_2")
	private int int2;
	
	
	@Column(name="del_status")
	private int delStatus;
	
	
	@Column(name="string1")
	private int String1;
	
	
	@Column(name="string2")
	private int String2;
	
	
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	@Column(name="patient_id")
	private int patientId;
	

	

	
	

	public int getPregnancyId() {
		return pregnancyId;
	}

	public void setPregnancyId(int pregnancyId) {
		this.pregnancyId = pregnancyId;
	}

	

	public String getToFirtilityDate() {
		return toFirtilityDate;
	}

	public void setToFirtilityDate(String toFirtilityDate) {
		this.toFirtilityDate = toFirtilityDate;
	}

	public String getFirtilityDate() {
		return firtilityDate;
	}

	public void setFirtilityDate(String firtilityDate) {
		this.firtilityDate = firtilityDate;
	}

	public String getConceptionDate() {
		return conceptionDate;
	}

	public void setConceptionDate(String conceptionDate) {
		this.conceptionDate = conceptionDate;
	}

	public String getFirstTrimisterDate() {
		return firstTrimisterDate;
	}

	public void setFirstTrimisterDate(String firstTrimisterDate) {
		this.firstTrimisterDate = firstTrimisterDate;
	}

	public String getSecondTrimisterDate() {
		return secondTrimisterDate;
	}

	public void setSecondTrimisterDate(String secondTrimisterDate) {
		this.secondTrimisterDate = secondTrimisterDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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

	public int getDelStatus() {
		return delStatus;
	}

	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;        
	}

	public int getString1() {
		return String1;
	}

	public void setString1(int string1) {
		String1 = string1;
	}

	public int getString2() {
		return String2;
	}

	public void setString2(int string2) {
		String2 = string2;
	}

	@Override
	public String toString() {
		return "PregnancyCalculator [pregnancyId=" + pregnancyId + ", toFirtilityDate=" + toFirtilityDate + ", date="
				+ date + ", time=" + time + ", firtilityDate=" + firtilityDate + ", conceptionDate=" + conceptionDate
				+ ", firstTrimisterDate=" + firstTrimisterDate + ", secondTrimisterDate=" + secondTrimisterDate
				+ ", dueDate=" + dueDate + ", int1=" + int1 + ", int2=" + int2 + ", delStatus=" + delStatus
				+ ", String1=" + String1 + ", String2=" + String2 + ", patientId=" + patientId + "]";
	}


	

	

	

	




}
