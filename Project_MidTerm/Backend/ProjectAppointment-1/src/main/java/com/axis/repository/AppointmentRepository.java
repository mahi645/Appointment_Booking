package com.axis.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.Appointment;


@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {

	//List<Appointment> findAllByAppointmentDate(LocalDate startDate, LocalDate endDate);
	List<Appointment> findAllByNameOfDoctor(String name);

}
