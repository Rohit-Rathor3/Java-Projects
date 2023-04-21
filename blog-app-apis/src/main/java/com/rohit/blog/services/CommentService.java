package com.rohit.blog.services;

import com.rohit.blog.payloads.CommentDto;

public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto , Integer postId);
	
	void deleteComment(Integer commentId);

}
