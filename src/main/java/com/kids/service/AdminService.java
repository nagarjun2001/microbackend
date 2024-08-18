package com.kids.service;

import java.util.List;

import com.kids.model.Admin;

public interface AdminService {

	public String addAdmin(Admin admin);
	public List<Admin> getAllAdmin();
	public Admin getAdminById(int id);
	public Admin getAdminByUsername(String username);
}
