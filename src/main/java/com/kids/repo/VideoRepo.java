package com.kids.repo;

import java.util.List;

import com.kids.model.Video;

public interface VideoRepo {

	public void save(Video video);
	public List<Video> findPending();
	public Video findById(int id);
	public void updateVideo(Video video);
	public void deleteVideo(int id);
	public List<Video> getAllVideos();
	public List<Video> findByApproved();
	public List<Video> findByCreatorId(int id);
}
