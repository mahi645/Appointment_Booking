package com.axis.service;

import java.util.List;

import com.axis.model.Admin;

public interface AdminService {

	public List<Admin> getAdmins();
	public Admin getAdminById(int id);
	public Admin addAdmin(Admin admin);
	public Admin updateAdmin(int id,Admin admin);
	public String deleteAdmin(int id);
	
}
