package com.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricket.entities.Player;
import com.cricket.entities.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
	
}
