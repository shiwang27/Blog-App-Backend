package com.app.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	Optional<User> findByEmail(String email);

}
