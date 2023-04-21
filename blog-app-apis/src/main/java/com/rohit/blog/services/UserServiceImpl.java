package com.rohit.blog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rohit.blog.entities.User;
import com.rohit.blog.exceptions.ResourceNotFoundException;
import com.rohit.blog.payloads.UserDto;
import com.rohit.blog.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService{
    
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto); 
		User savedUser = this.userRepo.save(user);
		return  this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto ,Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser =  this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer id) {
		User user = this.userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "Id", id));
		
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userDtos = users.stream().map(user->this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer id) {
      User user = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "Id", id));
      this.userRepo.delete(user);
		
	}
	
	public User dtoToUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto,User.class);
//		user.setId(userDto.getId());
//		user.setName(userDto.getName());
//		user.setEmail(userDto.getEmail());
//		user.setPassword(userDto.getPassword());
//		user.setAbout(userDto.getAbout());
		return user;
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
//		userDto.setId(user.getId());
//		userDto.setName(user.getName());
//		userDto.setEmail(user.getEmail());
//		userDto.setPassword(user.getPassword());
//		userDto.setAbout(user.getAbout());
		return userDto;
	}
}
