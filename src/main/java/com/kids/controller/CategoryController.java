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

import com.kids.model.Category;
import com.kids.serviceimplementation.CategorySerImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/category")
public class CategoryController {

	String s = "Success";
	String f = "Failure";
	String msg = "";
	
	CategorySerImpl service;

	public CategoryController(CategorySerImpl service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public String doAddCategory(@RequestBody Category cat) {
		try {
			service.saveCategory(cat);
			msg = s;
		}
		catch (Exception e) {
			msg = f;
		}
		return msg;
	}
	
	@GetMapping("/all")
	public List<Category> getAllCategory(){
		return service.findAllCategory();
	}
	
	@PutMapping
	public String doUpdateCategory(@RequestBody Category cat) {
		try {
			service.updateCategory(cat);
			msg = s;
		}
		catch (Exception e) {
			msg = f;
		}
		return msg;
	}
	
	@DeleteMapping("/{id}")
	public String doDelCategory(@PathVariable("id") int id) {
		try {
			service.deleteCategory(id);
			msg = s;
		}
		catch (Exception e) {
			msg = f;
		}
		return msg;
	}
	
	@GetMapping("/{id}")
	public Category doFindCategoryById(@PathVariable("id") int id) {
		return service.findByCategoryId(id);
	}
	
	@GetMapping("/Categoryname/{Categoryname}")
	public Category doFindByCategoryname(@PathVariable("Categoryname") String Categoryname) {
		return service.findByCatName(Categoryname);
	}
	
}
