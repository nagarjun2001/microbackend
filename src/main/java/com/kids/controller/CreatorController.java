package com.kids.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kids.model.Creator;
import com.kids.serviceimplementation.CreatorSerImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/creator")
public class CreatorController {

	String s = "Success";
	String f = "Failure";
	String msg = "";
	
	CreatorSerImpl service;

	public CreatorController(CreatorSerImpl service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public String doAddCreator(@RequestBody Creator cr) {
		try {
			service.saveCreator(cr);
			msg = s;
		}
		catch (Exception e) {
			msg = f;
		}
		return msg;
	}
	
	@GetMapping("/all")
	public List<Creator> getAllCreator(){
		return service.findAllCreator();
	}
	
	@PutMapping
	public String doUpdateCreator(@RequestBody Creator cr) {
		try {
			service.updateCreator(cr);;
			msg = s;
		}
		catch (Exception e) {
			msg = f;
		}
		return msg;
	}
	
	@DeleteMapping("/{id}")
	public String doDelCreator(@PathVariable("id") int id) {
		try {
			service.deleteCreator(id);
			msg = s;
		}
		catch (Exception e) {
			msg = f;
		}
		return msg;
	}
	
	@GetMapping("/{id}")
	public Creator doFindCreatorById(@PathVariable("id") int id) {
		return service.findByCreatorId(id);
	}
	
	@GetMapping("/email/{email}")
	public Creator doFindByCreatorEmail(@PathVariable("email") String email) {
		return service.findByEmail(email);
	}
}
