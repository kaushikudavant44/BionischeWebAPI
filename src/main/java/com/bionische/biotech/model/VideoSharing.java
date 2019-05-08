package com.bionische.biotech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_video_share")
public class VideoSharing {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int videoId;
	private int patientId;
	private int doctorId;
	private String title;
	private String videoFileName;
	private int delStatus;
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getVideoFileName() {
		return videoFileName;
	}
	public void setVideoFileName(String videoFileName) {
		this.videoFileName = videoFileName;
	}
	public int getDelStatus() {
		return delStatus;
	}
	public void setDelStatus(int delStatus) {
		this.delStatus = delStatus;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "VideoSharing [videoId=" + videoId + ", patientId=" + patientId + ", doctorId=" + doctorId + ", title="
				+ title + ", videoFileName=" + videoFileName + ", delStatus=" + delStatus + "]";
	}
	 
	
	
}
