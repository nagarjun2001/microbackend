package com.kids.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kids.model.Creator;
import com.kids.repo.CreatorRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CreatorRepoImpl implements CreatorRepo{

	EntityManager emanager;
	
	public CreatorRepoImpl(EntityManager emanager) {
		super();
		this.emanager = emanager;
	}

	@Override
	public void saveCreator(Creator cr) {
		emanager.persist(cr);
	}

	@Override
	public List<Creator> findAllCreator() {
		String hql = "From Creator";
		Query q = emanager.createQuery(hql);
		return q.getResultList();
	}

	@Override
	public Creator findByCreatorId(int id) {
		return emanager.find(Creator.class, id);
	}

	@Override
	public void updateCreator(Creator cat) {
		emanager.merge(cat);
	}

	@Override
	public void deleteCreator(int id) {
		Creator delcreator = findByCreatorId(id);
		emanager.remove(delcreator);
	}

	@Override
	public Creator findByEmail(String email) {
		String hql = "From Creator c where c.email = :email";
		Query q =  emanager.createQuery(hql);
		q.setParameter("email", email);
		return (Creator) q.getSingleResult();
	}

}
