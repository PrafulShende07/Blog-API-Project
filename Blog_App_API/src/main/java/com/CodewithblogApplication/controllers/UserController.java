package com.CodewithblogApplication.controllers;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CodewithblogApplication.payLoads.APIResponse;
import com.CodewithblogApplication.payLoads.UserDto;
import com.CodewithblogApplication.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// POST - create user
	@PostMapping("/createuser")
	public ResponseEntity<UserDto> createUser(@Valid  @RequestBody UserDto userDto){
		UserDto createuser = userService.createuser(userDto);
		return new ResponseEntity<UserDto>(createuser,HttpStatus.CREATED);
		
	}
	
	// PUT - update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updatedUser(@Valid  @RequestBody UserDto userDto,@PathVariable("userId")Integer userid){
		
		UserDto upadateUser = userService.upadateUser(userDto, userid);
		return ResponseEntity.ok(upadateUser);
		// or
	//	return new ResponseEntity<UserDto>(upadateUser,HttpStatus.OK);
		
	}
	
	// GET - get user
	@GetMapping("/{getuser}")
	public ResponseEntity<UserDto> getUser(@PathVariable("getuser") Integer userId){
		UserDto userById = userService.getUserById(userId);
		return new ResponseEntity<UserDto>(userById,HttpStatus.OK);
		
	}
	@GetMapping("/getAlluser")
	public ResponseEntity <List<UserDto>> getAllUser(){
		List<UserDto> allUsers = userService.getAllUsers();
		return ResponseEntity.ok(allUsers);
		
	}
		
	// DELETE - delete user
	@DeleteMapping("/{UserId}")
	public ResponseEntity<APIResponse> Deleteuser(@PathVariable Integer UserId){
		userService.deleteUser(UserId);
		//return new ResponseEntity(Map.of("massege","user delete successfully"),HttpStatus.OK);
		//or  by creating APIresponse class
		return new ResponseEntity<APIResponse>(new APIResponse("user delete successfully", true),HttpStatus.OK);
		
	}
	

}
