package com.bionische.biotech.yoga.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pranayama_details")

public class PranayamaDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name="pranayamadetail_id")
	private int pranayamaDetailId;
	
	
	@Column(name="pranayamtype_id")
	private int pranayamaTypeId;
	
	@Column(name="teacher_id")
	private String teacherId;
		
	 
		@Column(name="description")
	private String description;
		
		public int getPranayamaDetailId() {
			return pranayamaDetailId;
		}

		public void setPranayamaDetailId(int pranayamaDetailId) {
			this.pranayamaDetailId = pranayamaDetailId;
		}

		public int getPranayamaTypeId() {
			return pranayamaTypeId;
		}

		public void setPranayamaTypeId(int pranayamaTypeId) {
			this.pranayamaTypeId = pranayamaTypeId;
		}

		public String getTeacherId() {
			return teacherId;
		}

		public void setTeacherId(String teacherId) {
			this.teacherId = teacherId;
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

		public String getString1() {
			return string1;
		}

		public void setString1(String string1) {
			this.string1 = string1;
		}

		public int getInt1() {
			return int1;
		}

		public void setInt1(int int1) {
			this.int1 = int1;
		}

		public String getInt2() {
			return int2;
		}

		public void setInt2(String int2) {
			this.int2 = int2;
		}

		public int getDelStatus() {
			return delStatus;
		}

		public void setDelStatus(int delStatus) {
			this.delStatus = delStatus;
		}

		@Column(name="image")
	private String image;
	
	@Column(name="string1")
private String string1;
	
	@Column(name="int_1")
	private int int1;
	

	@Column(name="int_2")
private String int2;
	
	@Column(name="del_status")
	private int delStatus;

	@Override
	public String toString() {
		return "PranayamaDetails [pranayamaDetailId=" + pranayamaDetailId + ", pranayamaTypeId=" + pranayamaTypeId
				+ ", teacherId=" + teacherId + ", description=" + description + ", image=" + image + ", string1="
				+ string1 + ", int1=" + int1 + ", int2=" + int2 + ", delStatus=" + delStatus + "]";
	}

	
}
