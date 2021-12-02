package com.cricket.service;


import java.util.List;


import com.cricket.entities.Tournament;

public interface TournamentService {
	public void save(Tournament tournament);
	public List<Tournament> findAll();
}
