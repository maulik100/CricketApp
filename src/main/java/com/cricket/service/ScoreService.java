package com.cricket.service;

import java.util.List;

import com.cricket.entities.Matches;
import com.cricket.entities.Score;
import com.cricket.entities.Team;

public interface ScoreService {
	
	//public void score(Matches matches,Team team, int runs);
	public void downWicket(Matches matches,Team team, int wicket);
	public Score getScore(Matches matches,Team team);
	public void score(Score score);
	

}
