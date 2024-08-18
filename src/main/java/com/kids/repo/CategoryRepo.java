package com.kids.repo;

import java.util.List;

import com.kids.model.Category;

public interface CategoryRepo {
	
	public void saveCategory(Category cat);
	public List<Category> findAllCategory();
	public Category findByCategoryId(int id);
	public void updateCategory(Category cat);
	public void deleteCategory(int id);
	public Category findByCatName(String Categoryname);
}
