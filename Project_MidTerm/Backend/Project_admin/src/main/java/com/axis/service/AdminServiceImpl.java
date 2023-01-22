package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.model.Admin1;
import com.axis.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminRepository userRepository;
	
	

	@Override
	public Admin1 findByUsername(String username) {
		// TODO Auto-generated method stub
		
		return userRepository.findByUsername(username);
		
	}

	@Override
	public Admin1 updateUser(long id, Admin1 userDetails) {
		// TODO Auto-generated method stub
		Admin1 user=userRepository.findById(id).orElseThrow();
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setUsername(userDetails.getUsername());
		return userRepository.save(user);
	}

	@Override
	public Admin1 addUser(Admin1 userDetails) {
		// TODO Auto-generated method stub
		return userRepository.save(userDetails);
	}

	@Override
	public List<Admin1> getAllUsers() {
		// TODO Auto-generated method stub
		List<Admin1> users=userRepository.findAll();
		return users;
	}

	@Override
	public String deleteUsers(long id) {
		// TODO Auto-generated method stub
		Admin1 user=userRepository.findById(id).orElseThrow();
		userRepository.delete(user);
		return "deleted successfully" ;
	}

	@Override
	public Admin1 findByUsernameAndPassword(String username,String password) {
		Admin1 user=userRepository.findByUsernameAndPassword(username, password);
		return user;
	}

}
