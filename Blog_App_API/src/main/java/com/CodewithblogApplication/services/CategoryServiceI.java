package com.CodewithblogApplication.services;

import java.util.List;

import com.CodewithblogApplication.payLoads.CategoryDto;

public interface CategoryServiceI {
	
	// create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	// update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
	// get
	CategoryDto getCategory(Integer categoryId);
	
	// get all category
	List<CategoryDto> getcategories();
	
	// delete
	void deleteCategory(Integer categoryId);

}
