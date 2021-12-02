package com.cricket.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cricket.entities.Team;
import com.cricket.entities.Tournament;
import com.cricket.repository.TournamentRepository;
import com.cricket.service.TournamentService;

@Repository
public class TournamentServiceImpl implements TournamentService {

	@Autowired
	TournamentRepository tournamentRepository;
	
	@Override
	public void save(Tournament tournament) {
		tournamentRepository.save(tournament);
	}

	@Override
	public List<Tournament> findAll() {
		List<Tournament> findAllTeam = tournamentRepository.findAll();
		return findAllTeam;
	}

}
