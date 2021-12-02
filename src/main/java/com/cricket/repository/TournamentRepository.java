package com.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricket.entities.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

}
