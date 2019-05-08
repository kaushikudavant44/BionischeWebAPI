package com.bionische.biotech.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bionische.biotech.model.GetBlogs;

public interface GetBlogsRepository extends JpaRepository<GetBlogs, Integer>{
	
	@Query(value="SELECT b.blog_id, b.blog_date, b.blog_title, b.blog_content, (SELECT Concat(doctor_details.f_name ,' ', doctor_details.l_name) FROM doctor_details WHERE doctor_details.doctor_id = b.blog_created_by) as blog_by, b.blog_image ,"
			+ " (SELECT  COUNT(*) FROM t_blog_likes_counter WHERE t_blog_likes_counter.blog_id =b.blog_id) AS likes_count FROM t_blogs b WHERE b.blog_id=:blogId ",nativeQuery=true)
	GetBlogs  findByBlogId(@Param("blogId")int blogId);
	
	
	
	@Query(value="SELECT b.blog_id, b.blog_date, b.blog_title ,(SELECT Concat(doctor_details.f_name ,' ', doctor_details.l_name) FROM doctor_details WHERE doctor_details.doctor_id = b.blog_created_by) as blog_by, b.blog_image ,b.is_used, (SELECT  COUNT(*) FROM t_blog_likes_counter WHERE t_blog_likes_counter.blog_id =b.blog_id) AS likes_count FROM t_blogs b"
			+ " WHERE b.is_used = 1 ORDER BY b.blog_id DESC;",nativeQuery=true)
	List<GetBlogs> findAll();

	
	
	@Query(value="SELECT b.blog_id, b.blog_date, b.blog_title, b.blog_content, (SELECT Concat(doctor_details.f_name ,' ', doctor_details.l_name) FROM doctor_details WHERE doctor_details.doctor_id = b.blog_created_by) as blog_by, b.blog_image ,"
			+ " (SELECT  COUNT(*) FROM t_blog_likes_counter WHERE t_blog_likes_counter.blog_id =b.blog_id) AS likes_count FROM t_blogs b WHERE b.blog_created_by=:drId ORDER BY b.blog_id DESC ",nativeQuery=true)
	List<GetBlogs> findByDrId(@Param("drId")int drId);
	
	
}
 