package com.bionische.biotech.yoga.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class GetYogaTypeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	@Column(name="yogatype_id")
	private int yogaTypeId;
	
	@Column(name="type_id")
    private int typeId;
	

	@Column(name="teacher_id")
    private String teacherId;
	
 
	@Column(name="description")
   private String description;
	
	@Column(name="image")
   private String image;

	

	@Column(name="type_name")
    private String typeName;
	
	@Column(name="f_name")
	private String fName;
	
	
	@Column(name="l_name")
	private String lName;
	
	
		@Column(name="del_status")
	    private int delStatus;


		public int getYogaTypeId() {
			return yogaTypeId;
		}


		public void setYogaTypeId(int yogaTypeId) {
			this.yogaTypeId = yogaTypeId;
		}


		public int getTypeId() {
			return typeId;
		}


		public void setTypeId(int typeId) {
			this.typeId = typeId;
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


		public String getTypeName() {
			return typeName;
		}


		public void setTypeName(String typeName) {
			this.typeName = typeName;
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


		public int getDelStatus() {
			return delStatus;
		}


		public void setDelStatus(int delStatus) {
			this.delStatus = delStatus;
		}


		@Override
		public String toString() {
			return "GetYogaTypeDetails [yogaTypeId=" + yogaTypeId + ", typeId=" + typeId + ", teacherId=" + teacherId
					+ ", description=" + description + ", image=" + image + ", typeName=" + typeName + ", fName="
					+ fName + ", lName=" + lName + ", delStatus=" + delStatus + "]";
		}
	
		

	






		
	
	}

	
	
	

	