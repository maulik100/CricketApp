package com.cricket.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


@Entity
public class Score {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "matche_Id")
	private Matches matches;
	
	@OneToOne
	@JoinColumn(name="team_id")
	private Team team;
	
	private Integer numberOfBalls;
	
	private Integer wickets;
	
	private Integer runs;
	
	@Transient
	private String overs;
	
	private Integer dotBalls;
	
	private Integer noFours;
	
	private Integer nosix;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Matches getMatches() {
		return matches;
	}

	public void setMatches(Matches matches) {
		this.matches = matches;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Integer getNumberOfBalls() {
		return numberOfBalls;
	}

	public void setNumberOfBalls(Integer numberOfBalls) {
		this.numberOfBalls = numberOfBalls;
	}

	public Integer getWickets() {
		if(wickets == null) {
			return 0;
		}else {
			return wickets;
		}
	}

	public void setWickets(Integer wickets) {
		this.wickets = wickets;
	}

	public Integer getRuns() {
		if(runs == null) {
			return 0;
		}else {
			return runs;
		}
	}

	public void setRuns(Integer runs) {
		this.runs = runs;
	}

	public String getOvers() {
		return overs = (numberOfBalls/6) +"."+ (numberOfBalls%6);
	}

	public Integer getDotBalls() {
		if(dotBalls == null) {
			return 0;
		}else {
			return dotBalls;
		}
	}

	public void setDotBalls(Integer dotBalls) {
		this.dotBalls = dotBalls;
	}

	public Integer getNoFours() {
		if(noFours == null) {
			return 0;
		}else {
			return noFours;
		}
	}

	public void setNoFours(Integer noFours) {
		this.noFours = noFours;
	}

	public Integer getNosix() {
		if(nosix == null) {
			return 0;
		}else {
			return nosix;
		}
	}

	public void setNosix(Integer nosix) {
		this.nosix = nosix;
	}

	
	
}
