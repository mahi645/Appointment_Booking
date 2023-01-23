package com.axis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.axis.model.Admin1;

public interface AdminService {
	public Admin1 findByUsername(String username);
	public Admin1 findByUsernameAndPassword(String username,String password);
	public Admin1 updateUser(long id,Admin1 userDetails);
	public Admin1 addUser(Admin1 userDetails);
	public List<Admin1> getAllUsers();
	public String deleteUsers(long id);
}
