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
import org.springframework.web.client.RestTemplate;

import com.axis.model.Admin1;
import com.axis.service.AdminService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v2")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	@Autowired
	RestTemplate restTemplate;
	@GetMapping("/signin/{username}")
	public ResponseEntity<Admin1> signin(@PathVariable String username){
		Admin1 user=adminService.findByUsername(username);
		return new ResponseEntity<Admin1>(user,HttpStatus.OK);
		
	}
	@GetMapping("/signin")
	public ResponseEntity<List<Admin1>> signin1(){
		List<Admin1> admin=adminService.getAllUsers();
		return new ResponseEntity<List<Admin1>>(admin,HttpStatus.OK);
	}
	@PostMapping("/signup")
	public ResponseEntity<Admin1> signup(@RequestBody Admin1 adminDetails){
		Admin1 user=adminService.addUser(adminDetails);
		return new ResponseEntity<Admin1>(user,HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Admin1> updateUser(@PathVariable long id,@RequestBody Admin1 userDetails){
		Admin1 user=adminService.updateUser(id, userDetails);
		return new ResponseEntity<Admin1>(user,HttpStatus.OK);
	}
	@GetMapping("/validate/{username}")
	public ResponseEntity<String> validateUser(@PathVariable String username,@RequestBody Admin1 user){
		   String msg = "";	
		   try {
			   Admin1 userData = adminService.findByUsername(username);
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
	public ResponseEntity<String> validateUser(@PathVariable String username,@PathVariable String password,@RequestBody Admin1 user){
		   String msg = "";	
		   try {
			   Admin1 userData = adminService.findByUsernameAndPassword(username, password);
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
	   public String validateUser(@RequestBody Admin1 user){
		   String msg = "";	
		   try {
			   Admin1 userData = adminService.findByUsernameAndPassword(user.getUsername(),user.getPassword());
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
		 return new ResponseEntity<String>(adminService.deleteUsers(id),HttpStatus.OK);
	 }
	 @GetMapping("/appointments")
	 public Object getAppointment(){
			List object=restTemplate.getForObject("http://APPOINTMENT-SERVICE/api/v3/appointments",List.class);
			return object;
			
	 }
	 @GetMapping("/doctors")
	 public Object getDoctors(){
			List object=restTemplate.getForObject("http://DOCTOR-SERVICE/api/v1/doctors",List.class);
			return object;
			
	 }
	 @GetMapping("/bookings/{nameOfDoctor}/{department}")
	 public Object getDoctors(@PathVariable String nameOfDoctor,@PathVariable String department){
			List object=restTemplate.getForObject("http://APPOINTMENT-SERVICE/api/v3/bookings/"+nameOfDoctor+"/"+department,List.class);
			return object;
			
	 }
	 
}
