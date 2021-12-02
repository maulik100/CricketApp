package com.cricket.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cricket.entities.Player;
import com.cricket.repository.PlayerRepository;
import com.cricket.service.PlayerService;

@Repository
public class PlayerServiceImpl implements PlayerService{

	@Autowired
	PlayerRepository playerRepository; 
	
	@Override
	public void save(Player player) {
		playerRepository.save(player);
	}

}
