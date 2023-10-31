package com.CodewithblogApplication.services.Impl;


import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodewithblogApplication.Entity.Category;
import com.CodewithblogApplication.Entity.Post;
import com.CodewithblogApplication.Entity.User;
import com.CodewithblogApplication.exceptions.ResourceNotFoundException;
import com.CodewithblogApplication.payLoads.PostDto;
import com.CodewithblogApplication.repositories.CategoryRepository;
import com.CodewithblogApplication.repositories.PostRepository;
import com.CodewithblogApplication.repositories.UserRepository;
import com.CodewithblogApplication.services.PostServiceI;

@Service
public class PostServiceImpl implements PostServiceI{
	
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRespository;
	

	@Override
	public PostDto createUser(PostDto postDto, Integer userId, Integer categoryId) {
		// to set the userId and categoryId with post
	User user = userRespository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
		
	Category category = categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "category id", categoryId));
		   
                                        //here convert postDto to post entity
             Post post = modelMapper.map(postDto, Post.class);
             post.setImageName("Default.png");    // here set image because we do not add in PostDto class
             post.setAddedDate(new Date(0));
             post.setUser(user);
             post.setCategory(category);
             
             Post newpost = postRepository.save(post);
		return modelMapper.map(newpost ,PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getAllPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getSinglepost(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostByCategory(Integer categoryId) {
		// to find id from database by using categoryId
		Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category","category id",categoryId));
		// by using postRepository to get custom method
		List<Post> listOfPost = postRepository.findByCategory(category);
		// all the post convert into postDto
		List<PostDto> postDtos = listOfPost.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {

		User user = userRespository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId));
		
		List<Post> posts = postRepository.findByUser(user);
		// convert posts to PostDto
		List<PostDto> ListOfPostDtos = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return ListOfPostDtos;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
