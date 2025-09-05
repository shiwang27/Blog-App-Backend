package com.app.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
