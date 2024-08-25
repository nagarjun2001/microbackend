package com.kids.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kids.model.Users;
import com.kids.repo.UserRepo;
import com.kids.service.UserService;

@Service
public class UserSerImpl implements UserService{

	UserRepo repo;

	public UserSerImpl(UserRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void addUser(Users user) {
		repo.addUser(user);
	}

	@Override
	public List<Users> getAllUsers() {
		return repo.getAllUsers();
	}

	@Override
	public void deleteUsers(int id) {
		repo.deleteUser(id);
	}

	@Override
	public Users findUserById(int id) {
		return repo.findUserById(id);
	}

	@Override
	public void updateUsers(Users user) {
		repo.updateUser(user);
	}

	@Override
	public Users findByUsername(String username) {
		return repo.findByUsername(username);
	}

	@Override
	public Users findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	@Override
    public void addBlockedVideo(int userId, Long videoId) {
        repo.addBlockedVideo(userId, videoId);
    }

    @Override
    public void removeBlockedVideo(int userId, Long videoId) {
        repo.removeBlockedVideo(userId, videoId);
    }

	@Override
	public void addBlockedCat(int userId, Long category) {
		repo.addBlockedCat(userId, category);
	}

	@Override
	public void removeBlockedCat(int userId, Long category) {
		repo.removeBlockedCat(userId, category);
	}
    
}
