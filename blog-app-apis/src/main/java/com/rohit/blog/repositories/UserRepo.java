package com.rohit.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>  {

	
}
