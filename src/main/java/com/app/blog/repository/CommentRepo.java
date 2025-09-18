package com.app.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.Entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
