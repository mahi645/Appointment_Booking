package com.axis.controller;

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
import org.springframework.web.client.RestTemplate;

import com.axis.model.Admin;
import com.axis.service.AdminService;

@RestController
@RequestMapping("/api/v5")
public class AdminController {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	AdminService adminService;
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAdmins(){
		return new ResponseEntity<List<Admin>>(adminService.getAdmins(),HttpStatus.OK);
	}
	
	@GetMapping("/admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable int id){
		Admin admin=adminService.getAdminById(id);
		return new ResponseEntity<Admin>(admin,HttpStatus.OK);
	}
	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		return new ResponseEntity<Admin>(adminService.addAdmin(admin),HttpStatus.OK);
	}
	@PutMapping("/admin")
	public ResponseEntity<Admin> updateAdmin(@PathVariable int id,@RequestBody Admin admin){
		return new ResponseEntity<Admin>(adminService.updateAdmin(id, admin),HttpStatus.OK);
	}
	@DeleteMapping("/admin/{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable int id){
		return new ResponseEntity<String>(adminService.deleteAdmin(id),HttpStatus.OK);
	}

	@GetMapping("/appointments")
	public Object getAppointment(){
		List object=restTemplate.getForObject("http://APPOINTMENT-SERVICE/api/v3/appointments",List.class);
		return object;
		
	}
	@GetMapping("/appointment/{nameOfDoctor}")
	public Object getAppointmentByDoctor(@PathVariable String nameOfDoctor ){
		List object=restTemplate.getForObject("http://APPOINTMENT-SERVICE/api/v3/appointmentName/"+nameOfDoctor,List.class);
		return object;
		
	}
	/*
	@PostMapping("doctor")
	public Object adddDoctor(@RequestBody Doctor doctor ){
		List object=restTemplate.getForObject("http://APPOINTMENT-SERVICE/api/v3/appointmentName/"+nameOfDoctor,List.class);
		return object;
	
	}*/
	@GetMapping("/doctors")
	public Object getAllDoctors(){
		List object=restTemplate.getForObject("http://DOCTOR-SERVICE/api/v1/doctors",List.class);
		return object;
		
	}
	
}
