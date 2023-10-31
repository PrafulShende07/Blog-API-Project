package com.CodewithblogApplication.controllers;

import java.util.List;

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
import com.CodewithblogApplication.payLoads.CategoryDto;
import com.CodewithblogApplication.services.CategoryServiceI;

@RestController
@RequestMapping("/apis/categories")
public class CategoryController {
	
	@Autowired
	private CategoryServiceI categoryServiceI;
	
	// create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		
		CategoryDto createCategory = categoryServiceI.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);
		
	}
	
	// update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){
		
		CategoryDto updateCategory = categoryServiceI.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);
		
	}
	// delete category
	@DeleteMapping("{catId}")
	public ResponseEntity<APIResponse> deleteCategory(@PathVariable Integer catId){
		
		categoryServiceI.deleteCategory(catId);
		return new ResponseEntity<APIResponse>(new APIResponse("category deleted successfully",true),HttpStatus.OK);
		
	}
	
	// get category
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable int catId){
		CategoryDto category = categoryServiceI.getCategory(catId);
		return new ResponseEntity<CategoryDto>(category,HttpStatus.OK);
		
	}
	
	// get all category
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		List<CategoryDto> getcategories = categoryServiceI.getcategories();
		// return new ResponseEntity<List<CategoryDto>>(getcategories,HttpStatus.OK);
		return ResponseEntity.ok(getcategories);
		
		
	}
	
	
	
	

}
