package com.app.blog.Service;

import java.util.List;

import com.app.blog.Payloads.PostDto;
import com.app.blog.Payloads.PostResponse;

public interface PostService {
	
	// create post
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	// update post
	PostDto updatePost(PostDto postDto, Integer postId);
	
	// delete post
	void deletePost(Integer postId);
	
	// get all posts (with pagination)
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);
	
	// get single post
	PostDto getPostById(Integer postId);
	
	// get posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	//search posts
	List<PostDto> searchPosts(String keyword);
}
