package com.app.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.blog.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}