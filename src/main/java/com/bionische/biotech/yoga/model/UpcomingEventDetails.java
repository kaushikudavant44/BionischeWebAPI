package com.bionische.biotech.yoga.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="upcoming_events")


public class UpcomingEventDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="event_id")
	private int eventId;
	
	@Column(name="teacher_id")
	private int teacherId;
	
	
	@Column(name="event_name")
	private String eventName;
	
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
	

	
	
	public int getEventId() {
		return eventId;
	}
	public void setEventId(int eventId) {
		this.eventId = eventId;
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
	
	@Override
	public String toString() {
		return "UpcomingEventDetails [eventId=" + eventId + ", teacherId=" + teacherId + ", date=" + date + ", time="
				+ time + ", location=" + location + ", description=" + description + ", eventName=" + eventName
				+ ", image=" + image + ", delStatus=" + delStatus + "]";
	}
	
	
	
	
	
	
	
}
