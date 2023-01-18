package com.axis.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.model.Appointment;
import com.axis.repository.AppointmentRepository;
@Service
public class AppointmentServiceimpl implements AppointmentService {
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Override
	public Optional<Appointment> getAppointmentById(int id) {
		// TODO Auto-generated method stub
		return appointmentRepository.findById(id);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}
/*
	@Override
	public List<Appointment> getByDateRangeSortedByTime(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return appointmentRepository.findAllByAppointmentDate(startDate,endDate);
	}
*/
	@Override
	public Appointment addAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment updateAppointment(int id,Appointment appointment) {
		// TODO Auto-generated method stub
		Appointment appointment1=appointmentRepository.findById(id).orElseThrow();
		appointment1.setNameOfDoctor(appointment.getNameOfDoctor());
		appointment1.setAge(appointment.getAge());
		appointment1.setAppointmentDate(appointment.getAppointmentDate());
		appointment1.setAppointmentTime(appointment.getAppointmentTime());
		appointment1.setProblem(appointment.getProblem());
		
		return appointmentRepository.save(appointment);
	}

	@Override
	public Appointment updateStatus(int id, Appointment appointment) {
		// TODO Auto-generated method stub
		Optional<Appointment> appointmentList=appointmentRepository.findById(id);
		if(appointmentList.isPresent()) {
			if(appointment.getStatus()!=null) {
				appointmentList.get().setStatus(appointment.getStatus());
			}
			return appointmentRepository.save(appointment);
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		appointmentRepository.deleteById(id);
		
	}

	@Override
	public List<Appointment> getAppointmentsByDoctor(String name) {
		// TODO Auto-generated method stub
		return appointmentRepository.findAllByNameOfDoctor(name);
	}

}
