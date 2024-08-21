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

import com.kids.model.Users;
import com.kids.serviceimplementation.UserSerImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/user")
public class UserController {
	String s = "Success";
	String f = "Failure";
	String msg = "";

	UserSerImpl service;

	public UserController(UserSerImpl service) {
		super();
		this.service = service;
	}
	
	@PostMapping
	public String doAddUser(@RequestBody Users user) {
		try {
			service.addUser(user);
			msg = s;
		}
		catch (Exception e) {
			msg = f;
		}
		return msg;
	}
	
	@GetMapping("/all")
	public List<Users> getAll(){
		return service.getAllUsers();
	}
	
	@PutMapping
	public String doUpdateUser(@RequestBody Users user) {
		try {
			service.updateUsers(user);
			msg = s;
		}
		catch (Exception e) {
			msg = f;
		}
		return msg;
	}
	
	@DeleteMapping("/{id}")
	public String doDelUser(@PathVariable("id") int id) {
		try {
			service.deleteUsers(id);
			msg = s;
		}
		catch (Exception e) {
			msg = f;
		}
		return msg;
	}
	
	@GetMapping("/{id}")
	public Users doFindUserById(@PathVariable("id") int id) {
		return service.findUserById(id);
	}
	
	@GetMapping("/username/{username}")
	public Users doFindByUsername(@PathVariable("username") String username) {
		return service.findByUsername(username);
	}
	
	@GetMapping("/email/{email}")
	public Users doFindByEmail(@PathVariable("email") String email) {
		return service.findByEmail(email);
	}
	
	@PostMapping("/{userId}/block/{videoId}")
	@CrossOrigin(origins = "http://localhost:3000")
    public String addBlockedVideo(@PathVariable("userId") int userId, @PathVariable("videoId") Long videoId) {
        try {
            service.addBlockedVideo(userId, videoId);
            msg = s;
        } catch (Exception e) {
            msg = f;
        }
        return msg;
    }

    @DeleteMapping("/{userId}/block/{videoId}")
    public String removeBlockedVideo(@PathVariable("userId") int userId, @PathVariable("videoId") Long videoId) {
        try {
            service.removeBlockedVideo(userId, videoId);
            msg = s;
        } catch (Exception e) {
            msg = f;
        }
        return msg;
    }
    
    @PostMapping("/{userId}/block/category/{category}")
    @CrossOrigin(origins = "http://localhost:3000")
    public String addBlockedCategory(@PathVariable("userId") int userId, @PathVariable("category") String category) {
        try {
            service.addBlockedCat(userId, category);
            msg = s;
        } catch (Exception e) {
            msg = f;
        }
        return msg;
    }

    @DeleteMapping("/{userId}/block/category/{category}")
    public String removeBlockedCategory(@PathVariable("userId") int userId, @PathVariable("category") String category) {
        try {
            service.removeBlockedCat(userId, category);
            msg = s;
        } catch (Exception e) {
            msg = f;
        }
        return msg;
    }
}
