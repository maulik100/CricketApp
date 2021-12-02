package com.cricket.controller;


import java.util.HashMap;
import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import com.cricket.entities.Matches;
import com.cricket.entities.Player;
import com.cricket.entities.Score;
import com.cricket.entities.Team;
import com.cricket.entities.Tournament;
import com.cricket.service.MatchService;
import com.cricket.service.PlayerService;
import com.cricket.service.ScoreService;
import com.cricket.service.TeamService;
import com.cricket.service.TournamentService;

@Controller
public class CricketController {
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private TournamentService tournamentService;
	
	@Autowired
	private MatchService matchService ;
	
	@Autowired
	private ScoreService scoreService;
	
	private static final int ZERO=0;
	private static final int ONE=1;
	private static final int FOUR=4;
	private static final int SIX=6;
	private static final int ALLOUT=6;
	
	@RequestMapping({"/"})
	public String login() {
		return "index";
	}
	
	@GetMapping("/Team")
	public String getTeam(Model model) {
		model.addAttribute("team", new Team());
		return "addteam";
	}
	
	@RequestMapping("/addTeam")
	public String addTeam(@ModelAttribute Team team, Model model) {
		teamService.save(team);
		return "redirect:/";
	}
	
	@GetMapping("/Player")
	public String getPlayer(Model model) {
		model.addAttribute("player", new Player());
		List<Team> teams = teamService.getAllTeam();
		Map<Long, String> teamsMap = new HashMap<Long, String>();
		for (Team team : teams) {
			teamsMap.put(team.getTeamId(),team.getTeamName());
		}
		model.addAttribute("teamsMap", teamsMap);
		return "addplayer";
	}
	
	@RequestMapping("/addPlayer")
	public String addPlayer(@ModelAttribute Player player, Model model) {
		playerService.save(player);
		return "redirect:/";
	}
	
	@GetMapping("/tournament")
	public String getTournament(Model model) {
		List<Team> teamList = teamService.findAll();
		model.addAttribute("teamList", teamList);
		model.addAttribute("tournament", new Tournament());
		return "addtournament";
	}
	
	@RequestMapping("/addTournament")
	public String addPlayer(@ModelAttribute Tournament tournament, Model model) {
		tournamentService.save(tournament);
		return "redirect:/";
	}
	
	@GetMapping("/match")
	public String getMatch(Model model) {
		List<Tournament> tournamentList = tournamentService.findAll();
		Map<Long, String> tournamentListMap = new HashMap<Long, String>();
		for (Tournament tournament : tournamentList) {
			tournamentListMap.put(tournament.getTournamentId(),tournament.getTournamentName());
		}
		List<Team> teamList = teamService.findAll();
		Map<Long, String> teamListMap = new HashMap<Long, String>();
		for (Team team : teamList) {
			teamListMap.put(team.getTeamId(),team.getTeamName());
		}
		model.addAttribute("teamListMap", teamListMap);
		model.addAttribute("tournamentListMap", tournamentListMap);
		model.addAttribute("Matches", new Matches());
		return "addmatches";
	}
	
	@RequestMapping("/addMatch")
	public String addMatch(@ModelAttribute Matches matches, Model model) {
		matchService.save(matches);
		return "redirect:/";
	}
	
	
	@GetMapping("/play")
	public String getPlay(Model model) {
		List<Tournament> tournamentList = tournamentService.findAll();
		Map<Long, String> tournamentListMap = new HashMap<Long, String>();
		for (Tournament tournament : tournamentList) {
			tournamentListMap.put(tournament.getTournamentId(),tournament.getTournamentName());
		}
		List<Team> teamList = teamService.findAll();
		Map<Long, String> teamListMap = new HashMap<Long, String>();
		for (Team team : teamList) {
			teamListMap.put(team.getTeamId(),team.getTeamName());
		}
		List<Matches> Matches =  matchService.findAll();
		Map<Long, String> MatchestMap = new HashMap<Long, String>();
		for (Matches match : Matches) {
			MatchestMap.put(match.getId(),match.getName());
		}
		List<Matches> MatchesTeam =  matchService.findAll();
		Map<Long, String> MatchestTeamMap = new HashMap<Long, String>();
		for (Matches matchesTeam : MatchesTeam) {
			MatchestTeamMap.put(matchesTeam.getFirstTeam().getTeamId(),matchesTeam.getFirstTeam().getTeamName());
			MatchestTeamMap.put(matchesTeam.getSecondTeam().getTeamId(),matchesTeam.getSecondTeam().getTeamName());
		}
		model.addAttribute("matchestMap", MatchestMap);
		model.addAttribute("matchestTeamMap", MatchestTeamMap);
		model.addAttribute("tournamentListMap", tournamentListMap);
		model.addAttribute("score", new Score());
		return "playmatch";
	}
	
	@RequestMapping("/addScore")
	public String addScore(@ModelAttribute Score score, Model model) {
		boolean isAllOut= false;
		Score scoreDetail = scoreService.getScore(score.getMatches(),score.getTeam());
			if(scoreDetail == null) {
				score.setNumberOfBalls(ONE);
				if(score.getWickets() !=ONE) {
					if(score.getRuns() == SIX ) {
						score.setNosix(ONE);
					}
					else if(score.getRuns() == FOUR) {
						score.setNoFours(ONE);
					}
					else if(score.getRuns() == ZERO) {
						score.setDotBalls(ONE);
					}
				}else {
					score.setWickets(ONE);
					score.setDotBalls(ONE);
				}
				scoreService.score(score);
			}else {
				if(scoreDetail.getWickets() < ALLOUT) {
					scoreDetail.setNumberOfBalls(scoreDetail.getNumberOfBalls()+ONE);
					if(score.getWickets() !=ONE) {
						if(score.getRuns() == SIX ) {
							scoreDetail.setNosix(scoreDetail.getNosix()+ONE);
							scoreDetail.setRuns(score.getRuns()+scoreDetail.getRuns());
						}
						else if(score.getRuns() == FOUR) {
							scoreDetail.setNoFours(scoreDetail.getNoFours()+ONE);
							scoreDetail.setRuns(score.getRuns()+scoreDetail.getRuns());
						}
						else if(score.getRuns() == ZERO) {
							scoreDetail.setDotBalls(scoreDetail.getDotBalls()+ONE);
						}else {
							scoreDetail.setRuns(score.getRuns()+scoreDetail.getRuns());
						}
					}else {
						scoreDetail.setWickets(scoreDetail.getWickets()+ONE);
						scoreDetail.setDotBalls(scoreDetail.getDotBalls()+ONE);
					}
					scoreService.score(scoreDetail);
				}else {
					isAllOut = true;
					model.addAttribute("isAllOut",isAllOut);
					return "/";
				}
			}	
		return "redirect:play";
	}
	
	@GetMapping("/Score")
	public String GetScore(Model model) {
		ScorePage(model);
		return "scoreboard";
	}
	
	public void ScorePage(Model model) {
		List<Matches> Matches =  matchService.findAll();
		Map<Long, String> MatchestMap = new HashMap<Long, String>();
		for (Matches match : Matches) {
			MatchestMap.put(match.getId(),match.getName());
		}
		List<Matches> MatchesTeam =  matchService.findAll();
		Map<Long, String> MatchestTeamMap = new HashMap<Long, String>();
		for (Matches matchesTeam : MatchesTeam) {
			MatchestTeamMap.put(matchesTeam.getFirstTeam().getTeamId(),matchesTeam.getFirstTeam().getTeamName());
			MatchestTeamMap.put(matchesTeam.getSecondTeam().getTeamId(),matchesTeam.getSecondTeam().getTeamName());
		}
		model.addAttribute("matchestMap", MatchestMap);
		model.addAttribute("matchestTeamMap", MatchestTeamMap);
		model.addAttribute("score", new Score());
	}
	
	@RequestMapping("/getTeamScore")
	public String getTeamScore(@ModelAttribute Score score, Model model) {
		boolean showScore = true;
		Score teamScoreDetail = scoreService.getScore(score.getMatches(), score.getTeam());
		ScorePage(model);
		model.addAttribute("teamScoreDetail", teamScoreDetail);
		model.addAttribute("showScore", showScore);
		return "scoreboard";
	}
	
	
}
