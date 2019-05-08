package com.bionische.biotech.model.lab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="radiologist_details")
public class RadiologistPndtDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	int id;
	
	@Column(name="user_name")
	String userName;
	
	@Column(name="password")
	String password;
	
	@Column(name="lab_id")
	int labId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLabId() {
		return labId;
	}

	public void setLabId(int labId) {
		this.labId = labId;
	}

	@Override
	public String toString() {
		return "RadiologistPndtDetails [id=" + id + ", userName=" + userName + ", password=" + password + ", labId="
				+ labId + "]";
	}
	
	

}
