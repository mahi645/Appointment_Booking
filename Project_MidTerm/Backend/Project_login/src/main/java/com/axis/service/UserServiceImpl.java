package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.model.UserDetails;
import com.axis.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	

	@Override
	public UserDetails findByUsername(String username) {
		// TODO Auto-generated method stub
		
		return userRepository.findByUsername(username);
		
	}

	@Override
	public UserDetails updateUser(long id, UserDetails userDetails) {
		// TODO Auto-generated method stub
		UserDetails user=userRepository.findById(id).orElseThrow();
		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setRole(userDetails.getRole());
		user.setUsername(userDetails.getUsername());
		return userRepository.save(user);
	}

	@Override
	public UserDetails addUser(UserDetails userDetails) {
		// TODO Auto-generated method stub
		return userRepository.save(userDetails);
	}

	@Override
	public List<UserDetails> getAllUsers() {
		// TODO Auto-generated method stub
		List<UserDetails> users=userRepository.findAll();
		return users;
	}

	@Override
	public String deleteUsers(long id) {
		// TODO Auto-generated method stub
		UserDetails user=userRepository.findById(id).orElseThrow();
		userRepository.delete(user);
		return "deleted successfully" ;
	}

	@Override
	public UserDetails findByUsernameAndPassword(String username,String password) {
		UserDetails user=userRepository.findByUsernameAndPassword(username, password);
		return user;
	}

}
