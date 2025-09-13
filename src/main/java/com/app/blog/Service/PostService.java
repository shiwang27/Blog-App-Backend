package com.app.blog.Service;

import java.util.List;

import com.app.blog.Payloads.PostDto;

public interface PostService {
	
	// create post
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	// update post
	PostDto updatePost(PostDto postDto, Integer postId);
	
	// delete post
	void deletePost(Integer postId);
	
	// get all posts
	List<PostDto> getAllPosts(Integer pageNumber, Integer pageSize);
	
	// get single post
	PostDto getPostById(Integer postId);
	
	// get posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	// get posts by user
	List<PostDto> getPostsByUser(Integer userId);

}