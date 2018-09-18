package com.bionische.biotech.yoga.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class GetUpcomingEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="teacher_id")
	private int teacherId;
	
	
	@Column(name="event_name")
	private String eventName;
	
	@Column(name="f_name")
	private String fName;
	
	
	@Column(name="l_name")
	private String lName;
	
	@Column(name="date")
    private String date;
	
	@Column(name="time")
   private String time;
	
	

	@Column(name="location")
	   private String location;
		
		@Column(name="description")
	   private String description;
		
		@Column(name="image")
	    private String image;
		
		@Column(name="del_status")
	    private int delStatus;
	
		

	





		public int getEventId() {
			return eventId;
		}






		public void setEventId(int eventId) {
			this.eventId = eventId;
		}






		public int getTeacherId() {
			return teacherId;
		}






		public void setTeacherId(int teacherId) {
			this.teacherId = teacherId;
		}






		public String getEventName() {
			return eventName;
		}






		public void setEventName(String eventName) {
			this.eventName = eventName;
		}











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






		public String getLocation() {
			return location;
		}






		public void setLocation(String location) {
			this.location = location;
		}






		public String getDescription() {
			return description;
		}






		public void setDescription(String description) {
			this.description = description;
		}






		public String getImage() {
			return image;
		}






		public void setImage(String image) {
			this.image = image;
		}






		public int getDelStatus() {
			return delStatus;
		}






		public void setDelStatus(int delStatus) {
			this.delStatus = delStatus;
		}






		public String getfName() {
			return fName;
		}






		public void setfName(String fName) {
			this.fName = fName;
		}






		public String getlName() {
			return lName;
		}






		public void setlName(String lName) {
			this.lName = lName;
		}
	
		

		@Override
		public String toString() {
			return "GetUpcomingEvent [eventId=" + eventId + ", teacherId=" + teacherId + ", eventName=" + eventName
					+ ", date=" + date + ", time=" + time + ", fName=" + fName + ", lName=" + lName + ", location="
					+ location + ", description=" + description + ", image=" + image + ", delStatus=" + delStatus + "]";
		}

		
	
	}

	
	
	

	