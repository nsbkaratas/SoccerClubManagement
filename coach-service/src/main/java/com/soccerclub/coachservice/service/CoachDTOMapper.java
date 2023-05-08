package com.soccerclub.coachservice.service;

import com.soccerclub.coachservice.dto.CoachDTO;
import com.soccerclub.coachservice.model.Coach;
import org.springframework.stereotype.Service;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CoachDTOMapper implements Function<Coach, CoachDTO> {

    private final TeamProxy teamProxy;

    public CoachDTOMapper(TeamProxy teamProxy) {
        this.teamProxy = teamProxy;
    }

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
                coach.getProfileImageId(),
                coach.getTeamIds().stream().map(teamProxy::getTeamById).collect(Collectors.toList())
        );
    }
}
