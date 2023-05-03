package com.soccerclub.teamservice.repository;

import com.soccerclub.teamservice.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
