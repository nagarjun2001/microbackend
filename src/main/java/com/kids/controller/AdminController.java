package com.kids.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.model.Admin;
import com.kids.serviceimplementation.AdminSerImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {
	String s = "Success";
	String f = "Failure";

	AdminSerImpl service;

	public AdminController(AdminSerImpl service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public String doAddAdmin(@RequestBody Admin admin) {
		String msg = "";
		try {
			service.addAdmin(admin);
			msg = s;
		}
		catch (Exception e) {
			msg = f;
		}
		return msg;
	}
	
	@GetMapping("/{id}")
	public Admin getAdminById(@PathVariable("id") int id)
	{
		return service.getAdminById(id);
	}
	
	@GetMapping("/all")
	public List<Admin> allAdminList(){
		return service.getAllAdmin();
	}
	
	@GetMapping("/username/{username}")
	public Admin getAdminByUsername(@PathVariable("username") String username) {
		return service.getAdminByUsername(username);
	}
}
