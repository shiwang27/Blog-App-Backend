package com.app.blog.Service;

import com.app.blog.Payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);

}
