package com.CodewithblogApplication.payLoads;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostDto {
	
	@Size(min=5, message="title charector must be min 5 ")
	private String title;
	@NotBlank
	private String content;
	private String imageName;
	
	private Date addedDate;
	
	private UserDto user;
	private CategoryDto category;

}
