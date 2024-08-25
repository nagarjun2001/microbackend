package com.kids.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kids.model.Category;
import com.kids.repo.CategoryRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CategoryRepoImpl implements CategoryRepo{

	EntityManager emanager;

	public CategoryRepoImpl(EntityManager emanager) {
		super();
		this.emanager = emanager;
	}

	@Override
	public void saveCategory(Category cat) {
		emanager.persist(cat);
	}

	@Override
	public List<Category> findAllCategory() {
		String hql = "From Category";
		Query q = emanager.createQuery(hql);
		return q.getResultList();
	}

	@Override
	public Category findByCategoryId(int id) {
		return emanager.find(Category.class, id);
	}

	@Override
	public void updateCategory(Category cat) {
		emanager.merge(cat);
	}

	@Override
	public void deleteCategory(int id) {
		Category cat = findByCategoryId(id);
		emanager.remove(cat);
	}

	@Override
	public Category findByCatName(String categoryname) {
		String hql = "From Category c where c.categoryname = :categoryname";
		Query q = emanager.createQuery(hql);
		q.setParameter("categoryname", categoryname);
		return (Category) q.getSingleResult();
	}

}
