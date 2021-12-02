package com.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cricket.entities.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{
	
}
