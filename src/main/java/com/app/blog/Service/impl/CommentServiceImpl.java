package com.app.blog.Service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.blog.Entities.Comment;
import com.app.blog.Entities.Post;
import com.app.blog.Exceptions.ResourceNotFoundException;
import com.app.blog.Payloads.CommentDto;
import com.app.blog.Service.CommentService;
import com.app.blog.repository.CommentRepo;
import com.app.blog.repository.PostRepo;


@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Post id", postId));
		
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		
		comment.setPost(post);
		
		Comment savedComment = this.commentRepo.save(comment);
		
		
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		
		Comment com = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "Comment id", commentId));
		
		this.commentRepo.delete(com);

	}

}
