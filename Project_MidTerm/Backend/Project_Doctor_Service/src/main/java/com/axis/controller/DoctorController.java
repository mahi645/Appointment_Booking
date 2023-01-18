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

import com.axis.model.Doctor;
import com.axis.service.DoctorService;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/v1")
public class DoctorController {
	
	@Autowired 
	DoctorService doctorService;
	
	@PostMapping("/doctor")
	public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor){
		Doctor doctor1=doctorService.addDoctor(doctor);
		return new ResponseEntity<Doctor>(doctor1,HttpStatus.OK);
	}
	
	@GetMapping("/doctors")
	public ResponseEntity<List<Doctor>> getAllDoctors(){
		List<Doctor> doctor=doctorService.getAllDoctors();
		return new ResponseEntity<List<Doctor>>(doctor,HttpStatus.OK);
	}

	@GetMapping("/doctor1/{id}")
	public ResponseEntity<Doctor> getDoctorById(@PathVariable int id){
		Doctor doctor=doctorService.getDoctorById(id);
		return new ResponseEntity<Doctor>(doctor,HttpStatus.OK);
	}
	
	@PutMapping("/doctor2/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable int id,@RequestBody Doctor doctor){
		Doctor doctor1=doctorService.updateDoctorById(id, doctor);
		return new ResponseEntity<Doctor>(doctor1,HttpStatus.OK);
	}
	@DeleteMapping("/doctor/{id}")
	public ResponseEntity<String> deleteDoctorById(@PathVariable int id){
		
		return new ResponseEntity<String>(doctorService.deleteDoctor(id),HttpStatus.OK);
	}
	@GetMapping("/doctors/{name}")
	public ResponseEntity<List<Doctor>> findByName(@PathVariable String name){
		List<Doctor> doctor=doctorService.findByName(name);
		return new ResponseEntity<List<Doctor>>(doctor,HttpStatus.OK);
	}
	@GetMapping("/bydepartment/{department}")
	public ResponseEntity<List<Doctor>> findByDepartment(@PathVariable String department){
		List<Doctor> doctor=doctorService.findByDepartment(department);
		return new ResponseEntity<List<Doctor>>(doctor,HttpStatus.OK);
	}
}
