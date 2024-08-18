package com.kids.serviceimplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kids.model.Creator;
import com.kids.repo.CreatorRepo;
import com.kids.service.CreatorService;

@Service
public class CreatorSerImpl implements CreatorService{

	CreatorRepo repo;

	public CreatorSerImpl(CreatorRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void saveCreator(Creator cr) {
		repo.saveCreator(cr);
	}

	@Override
	public List<Creator> findAllCreator() {
		return repo.findAllCreator();
	}

	@Override
	public Creator findByCreatorId(int id) {
		return repo.findByCreatorId(id);
	}

	@Override
	public void updateCreator(Creator cat) {
		repo.updateCreator(cat);
	}

	@Override
	public void deleteCreator(int id) {
		repo.deleteCreator(id);
	}

	@Override
	public Creator findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	
}
