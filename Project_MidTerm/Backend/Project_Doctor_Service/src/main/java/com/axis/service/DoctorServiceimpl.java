package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.IdNotFoundException;
import com.axis.exception.InvalidExperienceException;
import com.axis.exception.InvalidNameException;
import com.axis.model.Doctor;
import com.axis.repository.DoctorRepository;
import com.axis.util.AppConstant;
@Service
public class DoctorServiceimpl implements DoctorService {
	
	@Autowired
	public DoctorRepository doctorRepository;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		if(doctor.getName()==null) {
			throw new InvalidNameException(AppConstant.InvalidNameMessage);
		}
		else if(doctor.getExperience() < 0) {
			throw new InvalidExperienceException(AppConstant.InvalidNameMessage);
		}
		return doctorRepository.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctors() {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctorById(int id) {
		// TODO Auto-generated method stub
		return doctorRepository.findById(id).orElseThrow(()->new IdNotFoundException(AppConstant.IdNotFound));
	}

	@Override
	public Doctor updateDoctorById(int id, Doctor doctor) {
		// TODO Auto-generated method stub
		Doctor doctor1=doctorRepository.findById(id).orElseThrow(()->new IdNotFoundException(AppConstant.IdNotFound));
		doctor1.setName(doctor.getName());
		doctor1.setDepartment(doctor.getDepartment());
		doctor1.setExperience(doctor.getExperience());
		doctor1.setUsername(doctor.getUsername());
		doctor1.setPassword(doctor.getPassword());
		return doctorRepository.save(doctor1);
	}

	@Override
	public String deleteDoctor(int id) {
		// TODO Auto-generated method stub
		Doctor doctor=doctorRepository.findById(id).orElseThrow(()->new IdNotFoundException(AppConstant.IdNotFound));
		doctorRepository.delete(doctor);
		return AppConstant.DeleteMessage;
	}

	@Override
	public List<Doctor> findByName(String name) {
		// TODO Auto-generated method stub
		return doctorRepository.findByName(name);
	}

	@Override
	public List<Doctor> findByDepartment(String department) {
		// TODO Auto-generated method stub
		return doctorRepository.findByDepartment(department);
	}

	
}
