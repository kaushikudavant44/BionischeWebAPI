package com.bionische.biotech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_blog_likes_counter")
public class BlogLikes {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int likeId;
	
	
	private int blogId;
	
	private int userId;

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BlogLikes [likeId=" + likeId + ", blogId=" + blogId + ", userId=" + userId + "]";
	}
	
	
	
	
	
}
