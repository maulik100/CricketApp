package com.cricket.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Tournament {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long tournamentId;
	
	private String tournamentName;
	
	/*many to many one team can have multiple tournament*/
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "tournament_team",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
            )
    private Set<Team> teams = new HashSet<>();
	
	@OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Matches> matches = new HashSet<>();

	public Long getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(Long tournamentId) {
		this.tournamentId = tournamentId;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	public Set<Matches> getMatches() {
		return matches;
	}

	public void setMatches(Set<Matches> matches) {
		this.matches = matches;
	}
	
	
	
}
