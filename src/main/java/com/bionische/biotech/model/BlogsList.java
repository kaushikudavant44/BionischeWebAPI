package com.bionische.biotech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BlogsList {
	
	@Id
	private int blogId;

	private String blogDate;

	private String blogTitle;

	
	private String blogContent;

	private String blogImage;

	private String blogCreatedBy;

	private int likesCount;

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

	public String getBlogCreatedBy() {
		return blogCreatedBy;
	}

	public void setBlogCreatedBy(String blogCreatedBy) {
		this.blogCreatedBy = blogCreatedBy;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}

	@Override
	public String toString() {
		return "BlogsList [blogId=" + blogId + ", blogDate=" + blogDate + ", blogTitle=" + blogTitle + ", blogContent="
				+ blogContent + ", blogImage=" + blogImage + ", blogCreatedBy=" + blogCreatedBy + ", likesCount="
				+ likesCount + "]";
	}
	
	
	

}
