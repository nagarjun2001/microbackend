package com.kids.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kids.model.Video;
import com.kids.repo.VideoRepo;
import com.kids.service.VideoService;

@Service
public class VideoSerImpl implements VideoService{

	VideoRepo repo;

	public VideoSerImpl(VideoRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void save(Video video) {
		repo.save(video);
	}

	@Override
	public List<Video> findPending() {
		return repo.findPending();
	}

	@Override
	public List<Video> findByApproved() {
		return repo.findByApproved();
	}

	@Override
	public Video findById(int id) {
		return repo.findById(id);
	}

	@Override
	public void updateVideo(Video video) {
		repo.updateVideo(video);
	}

	@Override
	public void deleteVideo(int id) {
		repo.deleteVideo(id);
	}

	@Override
	public List<Video> getAllVideos() {
		return repo.getAllVideos();
	}

	@Override
	public List<Video> findByCreatorId(int id) {
		return repo.findByCreatorId(id);
	}
	
	
}
