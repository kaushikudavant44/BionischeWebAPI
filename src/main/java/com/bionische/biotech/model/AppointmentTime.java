package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="appointment_time")
public class AppointmentTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="time_id")
	private int timeId;
	
	@Column(name="time")
	private String time;
	
	@Column(name="int_1")
	private int int1;
	
	@Column(name="string1")
	private String string1;

	public int getTimeId() {
		return timeId;
	}
	public void setTimeId(int timeId) {
		this.timeId = timeId;
	}
	 
	public int getInt1() {
		return int1;
	}
	public void setInt1(int int1) {
		this.int1 = int1;
	}
	public String getString1() {
		return string1;
	}
	public void setString1(String string1) {
		this.string1 = string1;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "AppointmentTime [timeId=" + timeId + ", time=" + time + ", int1=" + int1 + ", string1=" + string1 + "]";
	}
	
}
