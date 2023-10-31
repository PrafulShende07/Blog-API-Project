package com.CodewithblogApplication.services;

import java.util.List;

import com.CodewithblogApplication.payLoads.UserDto;

public interface UserService {
	
	UserDto createuser(UserDto user);
	UserDto upadateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);
	

}
