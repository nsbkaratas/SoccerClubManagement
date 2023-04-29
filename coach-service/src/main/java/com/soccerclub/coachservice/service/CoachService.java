package com.soccerclub.coachservice.service;

import com.soccerclub.coachservice.exception.CoachIdNotFoundException;
import com.soccerclub.coachservice.model.Coach;
import com.soccerclub.coachservice.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {
    @Autowired
    private CoachRepository coachRepository;


    public Coach saveCoach(Coach coach) {
        return coachRepository.save(coach);
    }

    public List<Coach> findAllCoach() {
        return coachRepository.findAll();
    }

    public Coach findCoachById(Integer id) {
        Optional<Coach> coach = coachRepository.findById(id);
        if (coach.isPresent()){
            return coach.get();
        }
        throw new CoachIdNotFoundException(id);
    }

    public Coach updateCoach(Integer id, Coach coach) {
        Coach coachToUpdate = findCoachById(id);
        coachToUpdate.setEmail(coach.getEmail());
        coachToUpdate.setFirstName(coach.getFirstName());
        coachToUpdate.setLastName(coach.getLastName());
        coachToUpdate.setPhoneNumber(coach.getPhoneNumber());
        coachToUpdate.setPassword(coach.getPassword());
        coachToUpdate.setTeams(coach.getTeams());
        return coachRepository.save(coachToUpdate);
    }
}
