package com.kids.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kids.model.Category;
import com.kids.repo.CategoryRepo;
import com.kids.service.CategoryService;

@Service
public class CategorySerImpl implements CategoryService{

	CategoryRepo repo;

	public CategorySerImpl(CategoryRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void saveCategory(Category cat) {
		repo.saveCategory(cat);
	}

	@Override
	public List<Category> findAllCategory() {
		return repo.findAllCategory();
	}

	@Override
	public Category findByCategoryId(int id) {
		return repo.findByCategoryId(id);
	}

	@Override
	public void updateCategory(Category cat) {
		repo.updateCategory(cat);
	}

	@Override
	public void deleteCategory(int id) {
		repo.deleteCategory(id);
	}

	@Override
	public Category findByCatName(String Categoryname) {
		return repo.findByCatName(Categoryname);
	}
	
}
