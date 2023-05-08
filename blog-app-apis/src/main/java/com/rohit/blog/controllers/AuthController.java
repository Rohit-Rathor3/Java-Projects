package com.rohit.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.blog.exceptions.ApiException;
import com.rohit.blog.payloads.UserDto;
import com.rohit.blog.security.AuthRequest;
import com.rohit.blog.security.JwtService;
import com.rohit.blog.services.UserService;


@RestController
@RequestMapping("/api/")
public class AuthController {

	@Autowired
	private JwtService jwtService;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired 
	private  UserService IuserService;
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@PostMapping("/login")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) throws ApiException{
		System.out.println("In auth controller ");
		System.out.println("AuthController.authenticateAndGetToken() username and password -- "+authRequest.getUsername() +" "+authRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        System.out.println("in auth after authentication");
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new ApiException("invalid username and password!!");
        }
    }
	
	//register new user api
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUSer(@RequestBody UserDto userDto){
	 UserDto registeredUser = 	this.IuserService.registerNewUser(userDto);
	 
	 return new ResponseEntity<UserDto>(registeredUser,HttpStatus.CREATED);
		
		
	}
}