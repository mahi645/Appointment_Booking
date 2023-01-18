package com.axis.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.axis.model.Appointment;

public interface AppointmentService {
	public Optional<Appointment> getAppointmentById(int id);
	public List<Appointment> getAllAppointments();
	//public List<Appointment> getByDateRangeSortedByTime(LocalDate startDate,LocalDate endDate);
	public Appointment addAppointment(Appointment appointment);
	public Appointment updateAppointment(int id,Appointment appointment);
	public Appointment updateStatus(int id,Appointment appointment);
	public void deleteById(int id);
	public List<Appointment> getAppointmentsByDoctor(String name);	
	

}
