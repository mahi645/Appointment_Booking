package com.axis.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.model.Appointment;
import com.axis.service.AppointmentService;

@RestController
@RequestMapping("/api/v3")
public class AppointmentController {
	@Autowired 
	private AppointmentService appointmentService;
	
	@GetMapping("/appointments")
	public ResponseEntity<List<Appointment>> getAllAppointment(){
		return new ResponseEntity<List<Appointment>>(appointmentService.getAllAppointments(),HttpStatus.OK);
	}
	@GetMapping("/appointment/{id}")
	public ResponseEntity<Optional<Appointment>> getAppointmentById(@PathVariable int id){
		Optional<Appointment> appointment=appointmentService.getAppointmentById(id);
		return new ResponseEntity<Optional<Appointment>>(appointment,HttpStatus.OK);
	}
	@PostMapping("/appointment")
	public ResponseEntity<Appointment> addAppintment(@RequestBody Appointment appointment){
		return new ResponseEntity<Appointment>(appointmentService.addAppointment(appointment),HttpStatus.OK);
	}
	@PutMapping("/appointment/{id}")
	public ResponseEntity<Appointment> updateAppointment(@PathVariable int id,@RequestBody Appointment appointment){
		return new ResponseEntity<Appointment>(appointmentService.updateAppointment(id, appointment),HttpStatus.OK);
	}
	/*
	@GetMapping("/appointmentsort/{startDate}/{endDate}")
	public ResponseEntity<List<Appointment>> getByDateRangeSortedByTime(@PathVariable LocalDate startDate,@PathVariable LocalDate endDate){
		return new ResponseEntity<List<Appointment>>(appointmentService.getByDateRangeSortedByTime(startDate, endDate),HttpStatus.OK);
	}
	*/
	@PatchMapping("/appointment/{id}")
	public ResponseEntity<Appointment> updateStatus(@PathVariable int id,@RequestBody Appointment appointment){
		return new ResponseEntity<Appointment>(appointmentService.updateStatus(id, appointment),HttpStatus.OK);
		
	}
	@DeleteMapping("/appointment")
	public void deleteById(@PathVariable int id) {
		appointmentService.deleteById(id);
	}
	@GetMapping("appointmentName/{nameOfDoctor}")
	public  ResponseEntity<List<Appointment>> getAppointmentsByDoctor(@PathVariable String nameOfDoctor){
		return new ResponseEntity<List<Appointment>>(appointmentService.getAppointmentsByDoctor(nameOfDoctor),HttpStatus.OK);
	}

}
