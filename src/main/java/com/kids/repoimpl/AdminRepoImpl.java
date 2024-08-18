package com.kids.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kids.model.Admin;
import com.kids.repo.AdminRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdminRepoImpl implements AdminRepo{
	
	EntityManager emanager;
	

	public AdminRepoImpl(EntityManager emanager) {
		super();
		this.emanager = emanager;
	}


	@Override
	public void addAdmin(Admin admin) {
		if(admin != null) {
			emanager.persist(admin);
		}
	}


	@Override
	public List<Admin> getAllAdmins() {
		String hql = "From Admin";
		Query query = emanager.createQuery(hql);
		return query.getResultList();
	}


	@Override
	public Admin getAdminById(int id) {
		return emanager.find(Admin.class, id);
	}


	@Override
	public Admin getAdminByUsername(String username) {
		String hql = "From Admin a where a.username = :username";
		Query q = emanager.createQuery(hql);
		q.setParameter("username", username);
		return (Admin) q.getSingleResult();
	}

}
