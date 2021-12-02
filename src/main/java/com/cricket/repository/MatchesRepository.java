package com.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cricket.entities.Matches;

public interface MatchesRepository extends JpaRepository<Matches, Long>{

}
