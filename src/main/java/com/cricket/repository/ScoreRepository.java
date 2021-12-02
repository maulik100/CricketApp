package com.cricket.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cricket.entities.Score;


public interface ScoreRepository extends JpaRepository<Score,Long> {
	 
	@Query(value ="Select * from score s WHERE s.matche_id = ?1 and s.team_id = ?2",nativeQuery = true)
	public Score getScore(long matchId,long teamId);
}
