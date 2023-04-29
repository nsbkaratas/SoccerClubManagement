package com.soccerclub.coachservice.repository;

import com.soccerclub.coachservice.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoachRepository extends JpaRepository<Coach, Integer> {
}
