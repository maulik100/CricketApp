package com.cricket.service;

import java.util.List;

import com.cricket.entities.Team;

public interface TeamService {
	public void save(Team team);
	public List<Team> getAllTeam();
	public List<Team> findAll();
}
