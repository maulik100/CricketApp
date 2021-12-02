package com.cricket.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cricket.entities.Matches;
import com.cricket.entities.Team;
import com.cricket.repository.MatchesRepository;
import com.cricket.service.MatchService;

@Repository
public class MatchServiceImpl implements MatchService {

	@Autowired
	MatchesRepository matchesRepository; 
	
	@Override
	public void save(Matches matches) {
		matchesRepository.save(matches);
	}

	@Override
	public List<Matches> findAll() {
		List<Matches> allMatchs = matchesRepository.findAll();
		return allMatchs;
	}

}
