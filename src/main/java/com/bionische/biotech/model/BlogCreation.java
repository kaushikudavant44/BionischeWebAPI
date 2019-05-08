package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "t_blogs")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BlogCreation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int blogId;

	private String blogDate;

	private String blogTitle;

	
	private String blogContent;

	private String blogImage;

	private int blogCreatedBy;
	
	private boolean isUsed;

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getBlogDate() {
		return blogDate;
	}

	public void setBlogDate(String blogDate) {
		this.blogDate = blogDate;
	}

	public String getBlogTitle() {
		return blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogContent() {
		return blogContent;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	public String getBlogImage() {
		return blogImage;
	}

	public void setBlogImage(String blogImage) {
		this.blogImage = blogImage;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public int getBlogCreatedBy() {
		return blogCreatedBy;
	}

	public void setBlogCreatedBy(int blogCreatedBy) {
		this.blogCreatedBy = blogCreatedBy;
	}
	

	@Override
	public String toString() {
		return "BlogCreation [blogId=" + blogId + ", blogDate=" + blogDate + ", blogTitle=" + blogTitle
				+ ", blogContent=" + blogContent + ", blogImage=" + blogImage + ", blogCreatedBy=" + blogCreatedBy
				+ ", isUsed=" + isUsed + "]";
	}

	
}
