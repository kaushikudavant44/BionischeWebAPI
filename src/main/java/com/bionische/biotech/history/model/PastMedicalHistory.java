package com.bionische.biotech.history.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="past_medical_history ")




public class PastMedicalHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="pastmedihistory_id")	
	private int pastMedicalHistoryId;
	
	@Column(name="patient_id")	
	private int patientId;
		
		@Column(name="dieses_id")	
	private String diesesId;
		
		@Column(name="other")	
	private String other;
		
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

		public int getPastMedicalHistoryId() {
			return pastMedicalHistoryId;
		}

		public void setPastMedicalHistoryId(int pastMedicalHistoryId) {
			this.pastMedicalHistoryId = pastMedicalHistoryId;
		}

		public int getPatientId() {
			return patientId;
		}

		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}

		public String getDiesesId() {
			return diesesId;
		}

		public void setDiesesId(String diesesId) {
			this.diesesId = diesesId;
		}

		public String getOther() {
			return other;
		}

		public void setOther(String other) {
			this.other = other;
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
			return "PastMedicalHistory [pastMedicalHistoryId=" + pastMedicalHistoryId + ", patientId=" + patientId
					+ ", diesesId=" + diesesId + ", other=" + other + ", delStatus=" + delStatus + ", int1=" + int1
					+ ", int2=" + int2 + ", string1=" + string1 + ", string2=" + string2 + "]";
		}
	
	

	

	

	
	}
	
	
	
