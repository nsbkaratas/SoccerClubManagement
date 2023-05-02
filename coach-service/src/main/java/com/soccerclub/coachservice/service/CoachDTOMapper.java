package com.soccerclub.coachservice.service;

import com.soccerclub.coachservice.dto.CoachDTO;
import com.soccerclub.coachservice.model.Coach;
import com.soccerclub.coachservice.model.Team;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CoachDTOMapper implements Function<Coach, CoachDTO> {

    @Override
    public CoachDTO apply(Coach coach) {
        return new CoachDTO(
                coach.getId(),
                coach.getFirstName(),
                coach.getLastName(),
                coach.getEmail(),
                coach.getUserName(),
                coach.getPhoneNumber(),
                coach.getGender().getGender(),
                coach.getProfileImageId()
//                coach.getTeams()
//                        .stream()
//                        .map(Team::name) //team -> team.name()
//                        .collect(Collectors.toList())

        );
    }
}
