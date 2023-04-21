package com.rohit.blog.services;

import java.util.List;

import com.rohit.blog.payloads.CategoryDto;

public interface CategoryService {

	// create
	CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
    CategoryDto updateCategory(CategoryDto categoryDto , Integer id);
	
	//delete
	void deleteCategory(Integer id);
	
	//get
	CategoryDto getCategory(Integer categoryId);
	
	//get all
	List<CategoryDto> getCategories();
}
