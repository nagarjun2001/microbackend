package com.kids.service;

import java.util.List;
import com.kids.model.Users;

public interface UserService {

	public void addUser(Users user);
	public List<Users> getAllUsers();
	public void deleteUsers(int id);
	public Users findUserById(int id);
	public void updateUsers(Users user);
	public Users findByUsername(String username);
	public Users findByEmail(String email);
	void addBlockedVideo(int userId, Long videoId);
    void removeBlockedVideo(int userId, Long videoId);
    void addBlockedCat(int userId, Long category);
    void removeBlockedCat(int userId, Long category);
}
