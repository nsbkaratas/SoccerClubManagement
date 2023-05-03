package com.soccerclub.teamservice.service;

import com.soccerclub.teamservice.dto.TeamDto;
import com.soccerclub.teamservice.model.Team;
import org.springframework.stereotype.Service;

import java.util.function.Function;


@Service
public class TeamDtoMapper implements Function<Team, TeamDto> {

    @Override
    public TeamDto apply(Team team) {
        return new TeamDto(
                team.getId(),
                team.getName(),
                team.getAgeGroup()
        );
    }
}

