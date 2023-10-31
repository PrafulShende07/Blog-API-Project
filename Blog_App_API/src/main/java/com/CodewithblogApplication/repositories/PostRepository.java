package com.CodewithblogApplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CodewithblogApplication.Entity.Category;
import com.CodewithblogApplication.Entity.Post;
import com.CodewithblogApplication.Entity.User;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
	//custom method 
	 List<Post> findByUser(User user);
	 List<Post> findByCategory(Category category);

}
