package com.soccerclub.teamservice.repository;

import com.soccerclub.teamservice.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    boolean existsByName(String name);

    Optional<Team> findByName(String teamName);
}
