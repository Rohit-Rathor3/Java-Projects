package com.rohit.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohit.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
