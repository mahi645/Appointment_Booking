package com.axis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axis.model.UserDetails;

public interface UserService {
	public UserDetails findByUsername(String username);
	public UserDetails findByUsernameAndPassword(String username,String password);
	public UserDetails updateUser(long id,UserDetails userDetails);
	public UserDetails addUser(UserDetails userDetails);
	public List<UserDetails> getAllUsers();
	public String deleteUsers(long id);
}
