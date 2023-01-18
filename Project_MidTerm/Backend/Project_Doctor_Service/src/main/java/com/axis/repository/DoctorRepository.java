package com.axis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{
	public List<Doctor> findByName(String name);
	public List<Doctor> findByDepartment(String department);

}
