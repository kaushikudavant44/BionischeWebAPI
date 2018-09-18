package com.bionische.biotech.insurance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="insurance_child_member_details")
public class ChildMemberDetails {

	 		 				 		 	


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="insu_child_id")
	private int insuChildId;

	@Column(name="insu_reg_id")
	private int insuRegId;
	
	@Column(name="child_fname")
	private String childFname;
	
	@Column(name="child_mname")
	private String childMname;
	
	@Column(name="child_lname")
	private String childLname;
	
	
	@Column(name="gender")
	private String gender;
	
	
	@Column(name="relation_with_proposer")
	private String relationWithProposer;
	
	
	@Column(name="dob")
	private String dob;
	

	@Column(name="height")
	private float height;
	

	@Column(name="weight")
	private float weight;
	
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
	
	@Column(name="policy_no")
	private int policyNo;
	
	public int getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(int policyNo) {
		this.policyNo = policyNo;
	}

	public int getInsuChildId() {
		return insuChildId;
	}

	public void setInsuChildId(int insuChildId) {
		this.insuChildId = insuChildId;
	}

	public int getInsuRegId() {
		return insuRegId;
	}

	public void setInsuRegId(int insuRegId) {
		this.insuRegId = insuRegId;
	}

	public String getChildFname() {
		return childFname;
	}

	public void setChildFname(String childFname) {
		this.childFname = childFname;
	}

	public String getChildMname() {
		return childMname;
	}

	public void setChildMname(String childMname) {
		this.childMname = childMname;
	}

	public String getChildLname() {
		return childLname;
	}

	public void setChildLname(String childLname) {
		this.childLname = childLname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRelationWithProposer() {
		return relationWithProposer;
	}

	public void setRelationWithProposer(String relationWithProposer) {
		this.relationWithProposer = relationWithProposer;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	 
	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
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
		return "ChildMemberDetails [insuChildId=" + insuChildId + ", insuRegId=" + insuRegId + ", childFname="
				+ childFname + ", childMname=" + childMname + ", childLname=" + childLname + ", gender=" + gender
				+ ", relationWithProposer=" + relationWithProposer + ", dob=" + dob + ", height=" + height + ", weight="
				+ weight + ", delStatus=" + delStatus + ", int1=" + int1 + ", int2=" + int2 + ", string1=" + string1
				+ ", string2=" + string2 + "]";
	}
	
	
}
