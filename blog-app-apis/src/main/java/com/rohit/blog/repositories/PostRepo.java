package com.rohit.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.blog.entities.Category;
import com.rohit.blog.entities.Post;
import com.rohit.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	
	List<Post> findByTitleContaining(String title);
}
