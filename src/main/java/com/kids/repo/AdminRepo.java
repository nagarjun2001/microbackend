package com.kids.repo;

import java.util.List;

import com.kids.model.Admin;

public interface AdminRepo {
	
	public void addAdmin(Admin admin);
	public Admin getAdminById(int id);
	public Admin getAdminByUsername(String username);
	public List<Admin> getAllAdmins();
}
