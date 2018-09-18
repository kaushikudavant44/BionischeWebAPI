package com.bionische.biotech.insurance.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_criticalfactory")

public class InsuranceCriticalFactor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="critical_factor_Id")
	private int criticalFactorId;
	
	
	@Column(name="company_id")
	private int companyId;
	
	@Column(name="critical_factor")
    private String criticalFactor;
	
	@Column(name="coverage")
    private String coverage;
	  
	@Column(name="int_1")
    private int int1;
	

	@Column(name="int_2")
    private int int2;

	@Column(name="del_status")
    private int delStatus;
	
	@Column(name="string1")
    private String string1;
	
	@Column(name="string2")
    private String string2;

	public int getCriticalFactorId() {
		return criticalFactorId;
	}

	public void setCriticalFactorId(int criticalFactorId) {
		this.criticalFactorId = criticalFactorId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCriticalFactor() {
		return criticalFactor;
	}

	public void setCriticalFactor(String criticalFactor) {
		this.criticalFactor = criticalFactor;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
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
		return "InsuranceCriticalFactory [criticalFactorId=" + criticalFactorId + ", companyId=" + companyId
				+ ", criticalFactor=" + criticalFactor + ", coverage=" + coverage + ", int1=" + int1 + ", int2=" + int2
				+ ", delStatus=" + delStatus + ", string1=" + string1 + ", string2=" + string2 + "]";
	}
	
	
	

}
