package com.bionische.biotech.history.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="family_history_details ")


public class FamilyHistoryDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="familyhistory_id")	
	private int familyHistoryId;
	
	@Column(name="father_age")	
private String fatherAge;
	
	@Column(name="mother_age")	
private String motherAge;
	
	@Column(name="siblings_age")	
private String siblingsAge;
	
	@Column(name="childrens_age")	
private String childrensAge;
	
	@Column(name="fhealth_sychiatric")	
private String fhealth_Psychiatric;
	
	@Column(name="mhealth_psychiatric")	
private String mhealth_Psychiatric;
	
	@Column(name="shealth_psychiatric")	
private String shealth_Psychiatric;
	
	@Column(name="chealth_psychiatric")	
private String cmhealth_Psychiatric;
	
	@Column(name="fage_at_death")	
private int fageAtDeath;
	
	@Column(name="mage_at_death")	
 private int mageAtDeath;
	
	@Column(name="sage_at_death")	
private int sageAtDeath;
	
	@Column(name="cage_at_death")	
 private int cageAtDeath;
	
	@Column(name="fcause")	
private String fcause;
	
	@Column(name="mcause")	
private String mcause;
	
	@Column(name="scause")	
private String scause;
	
	@Column(name="ccause")	
private String ccause;
	
	
	
	@Column(name="string1")	
private String string1;
	
	@Column(name="string2")	
private String string2;
	
	@Column(name="int_1")	
private int int1;
	
	@Column(name="int_2")	
private int int2;
	@Column(name="patient_id")	
	private int patientId;
		
	
	public int getFamilyHistoryId() {
		return familyHistoryId;
	}
	public void setFamilyHistoryId(int familyHistoryId) {
		this.familyHistoryId = familyHistoryId;
	}
	public String getFatherAge() {
		return fatherAge;
	}
	public void setFatherAge(String fatherAge) {
		this.fatherAge = fatherAge;
	}
	public String getMotherAge() {
		return motherAge;
	}
	public void setMotherAge(String motherAge) {
		this.motherAge = motherAge;
	}
	public String getSiblingsAge() {
		return siblingsAge;
	}
	public void setSiblingsAge(String siblingsAge) {
		this.siblingsAge = siblingsAge;
	}
	public String getChildrensAge() {
		return childrensAge;
	}
	public void setChildrensAge(String childrensAge) {
		this.childrensAge = childrensAge;
	}
	public String getFhealth_Psychiatric() {
		return fhealth_Psychiatric;
	}
	public void setFhealth_Psychiatric(String fhealth_Psychiatric) {
		this.fhealth_Psychiatric = fhealth_Psychiatric;
	}
	public String getMhealth_Psychiatric() {
		return mhealth_Psychiatric;
	}
	public void setMhealth_Psychiatric(String mhealth_Psychiatric) {
		this.mhealth_Psychiatric = mhealth_Psychiatric;
	}
	public String getShealth_Psychiatric() {
		return shealth_Psychiatric;
	}
	public void setShealth_Psychiatric(String shealth_Psychiatric) {
		this.shealth_Psychiatric = shealth_Psychiatric;
	}
	public String getCmhealth_Psychiatric() {
		return cmhealth_Psychiatric;
	}
	public void setCmhealth_Psychiatric(String cmhealth_Psychiatric) {
		this.cmhealth_Psychiatric = cmhealth_Psychiatric;
	}
	public int getFageAtDeath() {
		return fageAtDeath;
	}
	public void setFageAtDeath(int fageAtDeath) {
		this.fageAtDeath = fageAtDeath;
	}
	public int getMageAtDeath() {
		return mageAtDeath;
	}
	public void setMageAtDeath(int mageAtDeath) {
		this.mageAtDeath = mageAtDeath;
	}
	public int getSageAtDeath() {
		return sageAtDeath;
	}
	public void setSageAtDeath(int sageAtDeath) {
		this.sageAtDeath = sageAtDeath;
	}
	public int getCageAtDeath() {
		return cageAtDeath;
	}
	public void setCageAtDeath(int cageAtDeath) {
		this.cageAtDeath = cageAtDeath;
	}
	public String getFcause() {
		return fcause;
	}
	public void setFcause(String fcause) {
		this.fcause = fcause;
	}
	public String getMcause() {
		return mcause;
	}
	public void setMcause(String mcause) {
		this.mcause = mcause;
	}
	public String getScause() {
		return scause;
	}
	public void setScause(String scause) {
		this.scause = scause;
	}
	public String getCcause() {
		return ccause;
	}
	public void setCcause(String ccause) {
		this.ccause = ccause;
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
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	@Override
	public String toString() {
		return "FamilyHistoryDetails [familyHistoryId=" + familyHistoryId + ", fatherAge=" + fatherAge + ", motherAge="
				+ motherAge + ", siblingsAge=" + siblingsAge + ", childrensAge=" + childrensAge
				+ ", fhealth_Psychiatric=" + fhealth_Psychiatric + ", mhealth_Psychiatric=" + mhealth_Psychiatric
				+ ", shealth_Psychiatric=" + shealth_Psychiatric + ", cmhealth_Psychiatric=" + cmhealth_Psychiatric
				+ ", fageAtDeath=" + fageAtDeath + ", mageAtDeath=" + mageAtDeath + ", sageAtDeath=" + sageAtDeath
				+ ", cageAtDeath=" + cageAtDeath + ", fcause=" + fcause + ", mcause=" + mcause + ", scause=" + scause
				+ ", ccause=" + ccause + ", string1=" + string1 + ", string2=" + string2 + ", int1=" + int1 + ", int2="
				+ int2 + ", patientId=" + patientId + "]";
	}
	
	
	
	
}
