package com.CodewithblogApplication.services;

import java.util.List;

import com.CodewithblogApplication.Entity.Post;
import com.CodewithblogApplication.payLoads.PostDto;

public interface PostServiceI {
	
	// create post
	PostDto createUser(PostDto postDto, Integer userId, Integer categoryId);
	
	// update post
	PostDto updatePost(PostDto postDto, Integer postId);
	
	// delete
	void deletePost(Integer postId);
	
	// get all post
	List<Post> getAllPost();
	
	// get single post
	Post getSinglepost(Integer postId);
	
	// get all post by category
	List<PostDto> getPostByCategory(Integer categoryId);
	
	// get all post by User
	List<PostDto> getPostByUser(Integer userId);
	
	// search post
	List<Post> searchPost(String keyword);

}