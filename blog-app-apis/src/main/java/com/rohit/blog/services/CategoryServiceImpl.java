package com.rohit.blog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.blog.entities.Category;
import com.rohit.blog.exceptions.ResourceNotFoundException;
import com.rohit.blog.payloads.CategoryDto;
import com.rohit.blog.repositories.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {

        Category cat = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(cat);
        return this.modelMapper.map(addedCat, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
		
		Category cat = this.categoryRepo.findById(id).orElseThrow(()->
			new ResourceNotFoundException("Category ", "Category id", id));
		
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
        
		Category updatedCat = this.categoryRepo.save(cat);
		
		return this.modelMapper.map(updatedCat,CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer id) {
		
		Category cat = this.categoryRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Category ", "CategoryId", id));
		this.categoryRepo.delete(cat);

	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {

      Category cat = this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category ", "Category id", categoryId));
      
      return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		
		List<Category>  categories = this.categoryRepo.findAll();
		List<CategoryDto> catDtos =  categories.stream().map((cat)-> this.modelMapper.map(cat,CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
	}

}
