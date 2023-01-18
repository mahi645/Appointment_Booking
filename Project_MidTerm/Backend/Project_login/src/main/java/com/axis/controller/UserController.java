package com.axis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.UserDetails;
import com.axis.service.UserService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v6")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("/signin/{username}")
	public ResponseEntity<UserDetails> signin(@PathVariable String username){
		UserDetails user=userService.findByUsername(username);
		return new ResponseEntity<UserDetails>(user,HttpStatus.OK);
		
	}
	@GetMapping("/signin")
	public ResponseEntity<List<UserDetails>> signin1(){
		List<UserDetails> user=userService.getAllUsers();
		return new ResponseEntity<List<UserDetails>>(user,HttpStatus.OK);
	}
	@PostMapping("/signup")
	public ResponseEntity<UserDetails> signup(@RequestBody UserDetails userDetails){
		UserDetails user=userService.addUser(userDetails);
		return new ResponseEntity<UserDetails>(user,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDetails> updateUser(@PathVariable long id,@RequestBody UserDetails userDetails){
		UserDetails user=userService.updateUser(id, userDetails);
		return new ResponseEntity<UserDetails>(user,HttpStatus.OK);
	}
	@GetMapping("/validate/{username}")
	public ResponseEntity<String> validateUser(@PathVariable String username,@RequestBody UserDetails user){
		   String msg = "";	
		   try {
			   UserDetails userData = userService.findByUsername(username);
			   if(userData.getUsername().equals(user.getUsername())) {
					 msg = "valid";
				   }else {
					   msg="invalid";
		       } 
		   }catch(Exception ex) {
			   	msg ="invalid";
		   } 	   
		   
		return new ResponseEntity<String>(msg,HttpStatus.OK); 		   
	   }
	@GetMapping("/validate/{username}/{password}")
	public ResponseEntity<String> validateUser(@PathVariable String username,@PathVariable String password,@RequestBody UserDetails user){
		   String msg = "";	
		   try {
			   UserDetails userData = userService.findByUsernameAndPassword(username, password);
			   if(userData.getUsername().equals(user.getUsername()) && userData.getPassword().equals(user.getPassword())) {
					 msg = "valid";
				   }else {
					   msg="invalid";
		       } 
		   }catch(Exception ex) {
			   	msg ="invalid";
		   } 	   
		   
		return new ResponseEntity<String>(msg,HttpStatus.OK); 		   
	   }
	
	 @PostMapping("/validate")
	   public String validateUser(@RequestBody UserDetails user){
		   String msg = "";	
		   try {
			   UserDetails userData = userService.findByUsernameAndPassword(user.getUsername(),user.getPassword());
			   if( user.getUsername().equals(userData.getUsername()) && user.getPassword().equals(userData.getPassword())) {
					 msg = "valid";
				   }else {
					   return "invalid";
		       } 
		   }catch(Exception ex) {
			   	msg ="invalid";
		   } 	   
		   
		return msg; 		   
	   }
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteUsers(@PathVariable Long id) {
		 return new ResponseEntity<String>(userService.deleteUsers(id),HttpStatus.OK);
	 }

}
