package com.kids.repoimpl;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import com.kids.model.Users;
import com.kids.repo.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepoImpl implements UserRepo{

	EntityManager emanager;

	public UserRepoImpl(EntityManager emanager) {
		super();
		this.emanager = emanager;
	}

	@Override
	public void addUser(Users user) {
		emanager.persist(user);
	}

	@Override
	public List<Users> getAllUsers() {
		String hql = "From Users";
		Query query = emanager.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public void updateUser(Users user) {
		emanager.merge(user);
	}

	@Override
	public void deleteUser(int id) {
		Users user = findUserById(id);
			emanager.remove(user);
	}

	@Override
	public Users findUserById(int id) {
		return emanager.find(Users.class, id);
	}

	@Override
	public Users findByUsername(String uname) {
		String hql = "From Users u where u.uname = :uname";
		Query query = emanager.createQuery(hql);
		query.setParameter("uname", uname);
		return (Users) query.getSingleResult();
	}

	@Override
	public Users findByEmail(String email) {
		String hql = "From Users u where u.email = :email";
		Query q =  emanager.createQuery(hql);
		q.setParameter("email", email);
		return (Users) q.getSingleResult();
	}

	@Override
	public void addBlockedVideo(int userId, Long videoId) {
		Users user = findUserById(userId);
		if(user.getBlockedvideosid() != null) {
			user.getBlockedvideosid().add(videoId);
		}
		emanager.merge(user);
	}

	@Override
    public void removeBlockedVideo(int userId, Long videoId) {
        Users user = findUserById(userId);
        if (user.getBlockedvideosid() != null) {
            user.getBlockedvideosid().remove(videoId);
        }
        emanager.merge(user);
    }

	@Override
	public void addBlockedCat(int userId, String category) {
		Users user = findUserById(userId);
		if(!user.getBlockedcatid().contains(category)) {
			user.getBlockedcatid().add(category);
		}
		emanager.merge(user);
	}

	@Override
	public void removeBlockedCat(int userId, String category) {
		Users user = findUserById(userId);
		user.getBlockedcatid().remove(category);
		emanager.merge(user);
	}
	
}
