package com.cricket.service;

import java.util.List;

import com.cricket.entities.Matches;



public interface MatchService {

	public void save(Matches matches);
	public List<Matches> findAll();
}
