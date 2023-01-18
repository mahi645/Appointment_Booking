package com.axis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.exception.IdNotFoundException;
import com.axis.model.Admin;
import com.axis.repository.AdminRepository;
import com.axis.util.AppConstants;
@Service
public class AdminServiceimpl implements AdminService{
	@Autowired
	AdminRepository adminRepository;

	@Override
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return adminRepository.findAll();
	}

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		return adminRepository.findById(id).orElseThrow(()->new IdNotFoundException(AppConstants.IdNotFound));
	}

	@Override
	public Admin addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return  adminRepository.save(admin);
	}

	@Override
	public Admin updateAdmin(int id, Admin admin) {
		// TODO Auto-generated method stub
		Admin admin1= adminRepository.findById(id).orElseThrow(()->new IdNotFoundException(AppConstants.IdNotFound));
		admin1.setId(admin.getId());
		admin1.setName(admin.getName());
		admin1.setEmail(admin.getEmail());
		admin1.setRole(admin.getRole());
		return  adminRepository.save(admin1) ;
	}

	@Override
	public String deleteAdmin(int id) {
		// TODO Auto-generated method stub
		 adminRepository.deleteById(id);
		return AppConstants.DeleteMessage;
	}

}
