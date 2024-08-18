package com.kids.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kids.model.Admin;
import com.kids.repo.AdminRepo;
import com.kids.service.AdminService;

@Service
public class AdminSerImpl implements AdminService{

	AdminRepo repo;

	public AdminSerImpl(AdminRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String addAdmin(Admin admin) {
		repo.addAdmin(admin);
		return "Admin Added Successfully!";
	}

	@Override
	public List<Admin> getAllAdmin() {
		return repo.getAllAdmins();
	}

	@Override
	public Admin getAdminById(int id) {
		return repo.getAdminById(id);
	}

	@Override
	public Admin getAdminByUsername(String username) {
		return repo.getAdminByUsername(username);
	}
	
	
}
