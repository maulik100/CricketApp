package com.cricket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cricket.entities.Matches;
import com.cricket.entities.Score;
import com.cricket.entities.Team;
import com.cricket.repository.ScoreRepository;
import com.cricket.service.ScoreService;

@Repository
public class ScoreServiceImpl implements ScoreService{
	
	@Autowired
	ScoreRepository scoreRepository; 

	@Override
	public void downWicket(Matches matches, Team team, int wicket) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Score getScore(Matches matches, Team team) {
		Score score = scoreRepository.getScore(matches.getId(), team.getTeamId());
		return score;
	}

	@Override
	public void score(Score score) {
		scoreRepository.save(score);
	}

}
