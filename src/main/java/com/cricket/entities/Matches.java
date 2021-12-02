package com.cricket.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Matches {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	private String name;
	
	@OneToOne
	@JoinColumn(name="first_team")
	private Team firstTeam;
	
	@OneToOne
	@JoinColumn(name="second_team")
	private Team secondTeam;
	
	@OneToMany(mappedBy = "matches", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<Score> scores = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tournament_id")
	private Tournament tournament ;

	public long getId() {
		char a = 5;
		System.out.println(a);
		return id;
	}
	
public <T> void test(T t) {
	System.out.println(t);
}


public static void main(String[] args) {
	 Matches matches = new Matches();
	 matches.test("abcd");
	
}


	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getFirstTeam() {
		return firstTeam;
	}

	public void setFirstTeam(Team firstTeam) {
		this.firstTeam = firstTeam;
	}

	public Team getSecondTeam() {
		return secondTeam;
	}

	public void setSecondTeam(Team secondTeam) {
		this.secondTeam = secondTeam;
	}

	public Set<Score> getScores() {
		return scores;
	}

	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	
	
	
}
