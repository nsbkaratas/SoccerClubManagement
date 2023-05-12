package com.soccerclub.coachservice.repository;

import com.soccerclub.coachservice.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach, Integer> {

    Optional<Coach> findCoachByEmail(String email);
    boolean existsCoachById(Integer id);
    boolean existsCoachByEmail(String email);
    boolean existsCoachByUsername(String email);

    Optional<Coach> findCoachByUsername(String username);
}
