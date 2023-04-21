package com.rohit.blog.services;

import java.util.List;

import com.rohit.blog.payloads.PostDto;
import com.rohit.blog.payloads.PostResponse;

public interface PostService {

	// create
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer id);
	
	// get all post
	
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//get single post
	
	PostDto getPostById(Integer id);
	
	// get all post by category
	
	List<PostDto> getPostByCategory(Integer categoryId);
	
	//get post by user
	
	List<PostDto> getPostByUser(Integer userId);
	
	// get search post
	public List<PostDto> searchPosts(String keyword);
	
}
