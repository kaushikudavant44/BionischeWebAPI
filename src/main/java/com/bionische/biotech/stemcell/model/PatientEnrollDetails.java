package com.bionische.biotech.stemcell.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stemcell_enroll")

public class PatientEnrollDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="patientenroll_id")
	private int patientEnrollId;
	
	
	@Column(name="patient_id")
	private int patientId;

	@Column(name="stemcellbank_id")
	private int stemCellBankId;

	@Column(name="plan_id")   
	private int planId;
	
	
	
	
	@Column(name="hospital_id")
	private int hospitalId;
	
	
	
	
	

	@Column(name="time")
	private String time;
	
	@Column(name="date")
	private String date;



   
	@Column(name="state_id")
	private int stateId;
	
	
	@Column(name="city_id")
	private int cityId;
		
	
	@Column(name="country_id")
	private int countryId;
		
	
	@Column(name="pregnancy_type")
	private String pregnancyType;
		
		

	
	
	@Column(name="delivery_date")
	private String expectedDeliveryDate;
		
		
		
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



	public int getPatientEnrollId() {
		return patientEnrollId;
	}


	public void setPatientEnrollId(int patientEnrollId) {
		this.patientEnrollId = patientEnrollId;
	}


	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}




	public int getHospitalId() {
		return hospitalId;
	}


	public void setHospitalId(int hospitalId) {
		this.hospitalId = hospitalId;
	}


	

	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getStateId() {
		return stateId;
	}


	public void setStateId(int stateId) {
		this.stateId = stateId;
	}


	public int getCityId() {
		return cityId;
	}


	public void setCityId(int cityId) {
		this.cityId = cityId;
	}


	public int getCountryId() {
		return countryId;
	}


	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}


	public String getPregnancyType() {
		return pregnancyType;
	}


	public void setPregnancyType(String pregnancyType) {
		this.pregnancyType = pregnancyType;
	}


	public String getExpectedDeliveryDate() {
		return expectedDeliveryDate;
	}


	public void setExpectedDeliveryDate(String expectedDeliveryDate) {
		this.expectedDeliveryDate = expectedDeliveryDate;
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


	public int getStemCellBankId() {
		return stemCellBankId;
	}


	public void setStemCellBankId(int stemCellBankId) {
		this.stemCellBankId = stemCellBankId;
	}


	public int getPlanId() {
		return planId;
	}


	public void setPlanId(int planId) {
		this.planId = planId;
	}


	@Override
	public String toString() {
		return "PatientEnrollDetails [patientEnrollId=" + patientEnrollId + ", patientId=" + patientId
				+ ", stemCellBankId=" + stemCellBankId + ", planId=" + planId + ", hospitalId=" + hospitalId + ", time="
				+ time + ", date=" + date + ", stateId=" + stateId + ", cityId=" + cityId + ", countryId=" + countryId
				+ ", pregnancyType=" + pregnancyType + ", expectedDeliveryDate=" + expectedDeliveryDate + ", delStatus="
				+ delStatus + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2
				+ "]";
	}


	
	


	


	

}
