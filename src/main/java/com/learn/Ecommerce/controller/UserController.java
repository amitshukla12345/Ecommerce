package com.learn.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.Ecommerce.Dto.UserDto;
import com.learn.Ecommerce.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;
	
//	POST  ["/users"] To add user
	@PostMapping
	public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto userDto)
	{
		UserDto savedUser = userService.addUser(userDto);
		
		 return  new ResponseEntity<UserDto>(savedUser,HttpStatus.CREATED) ;
	}

//GET ["/users/101}"] To fetch user by id
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable String id)
	{
		UserDto userDto = userService.getUserById(id);
		return new ResponseEntity<UserDto>(userDto,HttpStatus.FOUND);
	}
	
//GET ["/users"] To fetch all users
	@GetMapping
	public ResponseEntity<List<UserDto>> fetchAllusers()
	{
		List<UserDto> users = userService.getAllUsers();
		System.out.println(users);
		return new ResponseEntity<List<UserDto>>(users,HttpStatus.OK);
	}
	
//DELETE ["/users/{id}"]

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable String id)
	{
		String message = userService.deleteUser(id);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
// PUT {"/users/{id}"}
	@PutMapping("/{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable String id, 
			           @RequestBody UserDto userDto)
	{
		UserDto updateUser = userService.updateUser(id,userDto);
		
		return new ResponseEntity<UserDto>(updateUser,HttpStatus.OK);
	}
	
	@GetMapping("/find-by-email/{emailId}")
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable String emailId)
	{
		return new ResponseEntity<UserDto>(userService.getUserByEmail(emailId),HttpStatus.OK);
		
	}
	
	@GetMapping("find-by-firstname")// request parameter are used hear
	 public ResponseEntity<List<UserDto>> getUserBYFirstName(@RequestParam String fname)
	 {
		 return new ResponseEntity<List<UserDto>>(userService.getUserByFirstName(fname),
				 HttpStatus.FOUND);
	 }
	
	
	
}
