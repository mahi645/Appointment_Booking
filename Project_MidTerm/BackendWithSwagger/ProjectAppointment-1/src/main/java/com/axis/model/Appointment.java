package com.axis.model;



import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;



@Entity
@Table(name="appointment")
public class Appointment {
	@Id
	@GeneratedValue
	private int id;
	private Timestamp createdAt=new Timestamp(System.currentTimeMillis());
	private String patientName;
	private String nameOfDoctor;
	private String department;
	private int age;
	private String problem;
	private LocalDate appointmentDate;
	private Time appointmentTime;
	private AppointmentStatus status=AppointmentStatus.Booked;
	public Appointment() {
		// TODO Auto-generated constructor stub
	}
	public Appointment(Timestamp createdAt, String nameOfDoctor, int age, String problem,
			LocalDate appointmentDate, Time appointmentTime,String patientName, AppointmentStatus status,String department) {
		super();
		this.createdAt = createdAt;
		this.nameOfDoctor = nameOfDoctor;
		this.age = age;
		this.problem = problem;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.status = status;
		this.department=this.department;
		this.patientName=this.patientName;
	}
	public Appointment(String nameOfDoctor,String patientName,String department, int age, String problem, LocalDate appointmentDate, Time appointmentTime) {
		super();
		this.nameOfDoctor = nameOfDoctor;
		this.age = age;
		this.problem = problem;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.department=this.department;
		this.patientName=this.patientName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public String getNameOfDoctor() {
		return nameOfDoctor;
	}
	public void setNameOfDoctor(String nameOfDoctor) {
		this.nameOfDoctor = nameOfDoctor;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProblem() {
		return problem;
	}
	public void setProblem(String problem) {
		this.problem = problem;
	}
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public Time getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(Time appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public AppointmentStatus getStatus() {
		return status;
	}
	public void setStatus(AppointmentStatus status) {
		this.status = status;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	
	
}
