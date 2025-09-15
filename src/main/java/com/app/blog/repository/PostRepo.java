package com.app.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.Entities.Category;
import com.app.blog.Entities.Post;
import com.app.blog.Entities.User;

public interface PostRepo extends JpaRepository<Post, Integer>{
	
	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findByTitleContaining(String title);
}