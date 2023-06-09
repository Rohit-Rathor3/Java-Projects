package com.rohit.blog.services;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rohit.blog.entities.Category;
import com.rohit.blog.entities.Post;
import com.rohit.blog.entities.User;
import com.rohit.blog.exceptions.ResourceNotFoundException;
import com.rohit.blog.payloads.PostDto;
import com.rohit.blog.payloads.PostResponse;
import com.rohit.blog.repositories.CategoryRepo;
import com.rohit.blog.repositories.PostRepo;
import com.rohit.blog.repositories.UserRepo;

@Service
public class PostServiceImpl implements PostService{
	
  @Autowired
  private PostRepo postRepo;
  
  @Autowired
  private ModelMapper modelmapper;
  @Autowired
  private UserRepo userRepo;
  @Autowired
  private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId, Integer categoryId) {
		User user =this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User ","User id", userId));
		Category category = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", "Category Id", categoryId));
		Post post = this.modelmapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post savedPost = this.postRepo.save(post);
		
		return this.modelmapper.map(savedPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post ","PostId",postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		
		Post updatedPost =this.postRepo.save(post);
		return this.modelmapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer id) {
		Post post = this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post" ,"Post id", id));
		this.postRepo.delete(post);
	} 

	@Override
	public PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir) {
		Sort sort =null;
		if(sortDir.equalsIgnoreCase("asc"))
			sort=Sort.by(sortBy).ascending();
		else
			sort=Sort.by(sortBy).descending();
		
			
		Pageable p = PageRequest.of(pageNumber, pageSize,sort);
		Page<Post>  pagePost = this.postRepo.findAll(p);
		
		List<Post> allPosts = pagePost.getContent();
		List<PostDto> postDtos =  allPosts.stream().map((post)->this.modelmapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		postResponse.setContent(postDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		return postResponse;
		
		
	}

	@Override
	public PostDto getPostById(Integer id) {
		 Post post =  this.postRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post ", "Post id", id));
		return this.modelmapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category ", "Category Id", categoryId));
		List<Post> posts =  this.postRepo.findByCategory(cat);
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelmapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "User Id", userId));
		List<Post> posts =  this.postRepo.findByUser(user);
		
		List<PostDto> postDtos = posts.stream().map((post)-> this.modelmapper.map(post,PostDto.class)).collect(Collectors.toList());
		
		return postDtos;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		List<Post> posts = this.postRepo.findByTitleContaining(keyword);
		List<PostDto> postDtos = posts.stream().map((post)->this.modelmapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

}
