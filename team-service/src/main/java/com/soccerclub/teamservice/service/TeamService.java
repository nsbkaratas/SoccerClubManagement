package com.soccerclub.teamservice.service;

import com.soccerclub.teamservice.dto.TeamDto;
import com.soccerclub.teamservice.exception.TeamAlreadyExists;
import com.soccerclub.teamservice.exception.TeamIdNotFoundException;
import com.soccerclub.teamservice.exception.TeamNameNotFoundException;
import com.soccerclub.teamservice.model.Team;
import com.soccerclub.teamservice.repository.TeamRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamDtoMapper teamDtoMapper;


    public void saveTeam(Team team) {
        if(teamRepository.existsByName(team.getName())){
            throw new TeamAlreadyExists(team.getName());
        }
        teamRepository.save(team);
    }

    public List<TeamDto> findAllTeams() {
        return teamRepository.findAll()
                .stream()
                .map(teamDtoMapper)
                .collect(Collectors.toList());
    }

    public TeamDto findTeamById(Integer id) {

        return teamRepository.findById(id)
                .map(teamDtoMapper)
                .orElseThrow(() -> new TeamIdNotFoundException(id));
    }

    public TeamDto findTeamByName(String teamName) {
        return teamRepository.findByName(teamName)
                .map(teamDtoMapper)
                .orElseThrow(() -> new TeamNameNotFoundException(teamName));
    }

    public void updateCoach(Integer id, Team team) {
    }
}
