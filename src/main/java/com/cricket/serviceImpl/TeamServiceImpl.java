package com.cricket.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.entities.Player;
import com.cricket.entities.Team;
import com.cricket.repository.TeamRepository;
import com.cricket.service.TeamService;

@Service
public class TeamServiceImpl implements TeamService{

	@Autowired
	TeamRepository teamRepository;
	
	@Override
	public void save(Team team) {
		teamRepository.save(team);
	}

	@Override
	public List<Team> getAllTeam() {
		List<Team> teamList = teamRepository.findAll();
		return teamList;
	}

	@Override
	public List<Team> findAll() {
		List<Team> findAllTeam = teamRepository.findAll();
		return findAllTeam;
	}

}
