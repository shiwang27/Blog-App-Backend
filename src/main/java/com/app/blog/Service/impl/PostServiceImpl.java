package com.app.blog.Service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.Entities.Category;
import com.app.blog.Entities.Post; // Corrected import
import com.app.blog.Entities.User;
import com.app.blog.Exceptions.ResourceNotFoundException;
import com.app.blog.Payloads.PostDto;
import com.app.blog.Service.PostService;
import com.app.blog.repository.CategoryRepo;
import com.app.blog.repository.PostRepo;
import com.app.blog.repository.UserRepo;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user = this.userRepo.findById(userId)
        		.orElseThrow(()-> new ResourceNotFoundException("User","User id",userId));
		
		Category category = this.categoryRepo.findById(categoryId) // Corrected repository call
        		.orElseThrow(()-> new ResourceNotFoundException("Category","category id",categoryId));
		
		Post post = this.modelMapper.map(postDto , Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post newPost= this.postRepo.save(post);
		
		return this.modelMapper.map(newPost, PostDto.class);
	}
	
	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
	}

	@Override
	public PostDto getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getAllPosts() { // Corrected method name and return type
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId)
        		.orElseThrow(()-> new ResourceNotFoundException("Category","category id",categoryId));
		List<Post> posts = this.postRepo.findByCategory(cat); // Corrected repository method name
		
		List<PostDto> postDtos = posts.stream()
	            .map((post) -> this.modelMapper.map(post, PostDto.class)) // Corrected mapping logic
	            .collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
        		.orElseThrow(()-> new ResourceNotFoundException("User","User id",userId));
		List<Post> posts = this.postRepo.findByUser(user); // Corrected repository method name
		List<PostDto> postDtos = posts.stream()
	            .map((post) -> this.modelMapper.map(post, PostDto.class)) // Corrected mapping logic
	            .collect(Collectors.toList());
		return postDtos;
	}

}