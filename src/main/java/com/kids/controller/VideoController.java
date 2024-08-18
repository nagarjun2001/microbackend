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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.kids.model.Category;
import com.kids.model.Creator;
import com.kids.model.Video;
import com.kids.repo.CategoryRepo;
import com.kids.repo.CreatorRepo;
import com.kids.serviceimplementation.VideoSerImpl;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/video")
public class VideoController {
	
	private static String s = "Success";
	private static String f = "Failure";
	private static String msg = "";
	
	VideoSerImpl service;
	CategoryRepo catser;
	CreatorRepo creatrepo;

	public VideoController(VideoSerImpl service, CategoryRepo catser,CreatorRepo creatrepo) {
		super();
		this.service = service;
		this.catser = catser;
		this.creatrepo = creatrepo;
	}

	@PostMapping("/upload")
	public String addVideo(@RequestParam("file") MultipartFile file,
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("category_id") int categoryId,
			@RequestParam("creator_id") int creatorId,
			@RequestParam("agelevel") String agelevel) {
		String msg1 = "";
		try {
			Category category = catser.findByCategoryId(categoryId);
            Creator creator = creatrepo.findByCreatorId(creatorId);

            if (category == null || creator == null) {
                return "Category or Creator not found!";
            }
            
			Video v = new Video();
			v.setTitle(title);
			v.setDescription(description);
			v.setVideofile(file.getBytes());
			v.setCategory(category);
			v.setCreator(creator);
			v.setAgelevel(agelevel);
			v.setStatus(false);
			
			service.save(v);
			msg1 = "Success";
		}
		catch (Exception e) {
			msg1 = "Failure";
		}
		return msg1;
	}
	
	@GetMapping("/all")
	public List<Video> getAll(){
		return service.getAllVideos();
	}
	
	@GetMapping("/pending")
	public List<Video> getPendingVideos() {
		return service.findPending();
	}

	@GetMapping("/approved")
	public List<Video> getApprovedVideos() {
		return service.findByApproved();
	}
	
	@PutMapping("/{id}")
	public String doUpdateVideo(@PathVariable("id") int id, @RequestBody Video v) {
		Video old = service.findById(id);
		if(old != null) {
			v.setId(id);
			service.updateVideo(v);
			return s;
		}
		return f;
	}
	
	@DeleteMapping("/{id}")
	public String doDelVid(@PathVariable("id") int id) {
		try {
			service.deleteVideo(id);
			msg = s;
		}
		catch (Exception e) {
			msg = f;
		}
		return msg;
	}
	
	@GetMapping("/{id}")
	public Video doFindVideoById(@PathVariable("id") int id) {
		return service.findById(id);
	}
	
	@GetMapping("/creator/{id}")
	public List<Video> doFindByCreatorId(@PathVariable("id") int id) {
		return service.findByCreatorId(id);
	}
}
