package com.rohit.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
