package com.rohit.blog.controllers;

import java.util.List;

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

import com.rohit.blog.payloads.ApiResponse;
import com.rohit.blog.payloads.CategoryDto;
import com.rohit.blog.services.CategoryService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
@SecurityRequirement(name = "bearerAuth")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	// create
	
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createdCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createdCategory, HttpStatus.CREATED);
	}
	//update
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoryDto> updateeCategory(@Valid @RequestBody CategoryDto categoryDto ,@PathVariable("id") Integer id ){
		CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,id);
		return new ResponseEntity<CategoryDto>(updatedCategory, HttpStatus.OK);
	}
	
	//delete
	
     @DeleteMapping("/{id}")
     public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("id") Integer id){
    	 this.categoryService.deleteCategory(id);
    	 return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfully!!",true),HttpStatus.OK);
     }
     
	//get
     
     @GetMapping("/{id}")
     public ResponseEntity<CategoryDto> getCategory(@PathVariable("id") Integer id){
    	CategoryDto categoryDto =  this.categoryService.getCategory(id);
    	return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
     }
	
	//get all
     
     @GetMapping("/")
     public ResponseEntity<List<CategoryDto>> getCategories(){
    	 List<CategoryDto> categoryDtos =  this.categoryService.getCategories();
    	 return ResponseEntity.ok(categoryDtos);
     }
}
