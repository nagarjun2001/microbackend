package com.kids.service;

import java.util.List;

import com.kids.model.Creator;

public interface CreatorService {

	public void saveCreator(Creator cr);
	public List<Creator> findAllCreator();
	public Creator findByCreatorId(int id);
	public void updateCreator(Creator cat);
	public void deleteCreator(int id);
	public Creator findByEmail(String email);
}
