package com.kids.repoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.kids.model.Video;
import com.kids.repo.VideoRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VideoRepoImpl implements VideoRepo{

	EntityManager emanager;

	public VideoRepoImpl(EntityManager emanager) {
		super();
		this.emanager = emanager;
	}

	@Override
	public void save(Video video) {
		emanager.persist(video);
	}

	@Override
	public List<Video> findPending() {
		String hql = "From Video where status = false";
		Query q = emanager.createQuery(hql, Video.class);
		return q.getResultList();
	}

	@Override
	public List<Video> findByApproved() {
		String hql = "From Video where status = true";
		Query q = emanager.createQuery(hql, Video.class);
		return q.getResultList();
	}

	@Override
	public Video findById(int id) {
		return emanager.find(Video.class, id);
	}

	@Override
	public void updateVideo(Video video) {
		emanager.merge(video);
	}

	@Override
	public void deleteVideo(int id) {
		Video delvideo = findById(id);
		if(delvideo != null) {
			emanager.remove(delvideo);
		}
	}

	@Override
	public List<Video> getAllVideos() {
		String hql = "From Video";
		Query q = emanager.createQuery(hql);
		return q.getResultList();
	}

	@Override
	public List<Video> findByCreatorId(int id) {
		String hql = "From Video cv where cv.creator.id = :creator_id";
		Query q = emanager.createQuery(hql);
		q.setParameter("creator_id", id);
		return q.getResultList();
	}
	
	
}
