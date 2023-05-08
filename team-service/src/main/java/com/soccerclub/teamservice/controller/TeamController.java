package com.soccerclub.teamservice.controller;

import com.soccerclub.teamservice.dto.TeamDto;
import com.soccerclub.teamservice.model.Team;
import com.soccerclub.teamservice.service.TeamService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    @PostMapping("/save")
    public ResponseEntity<?> saveTeam(@RequestBody Team team){

        teamService.saveTeam(team);
        log.warn("A team is created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/list/all")
    public List<TeamDto> getTeams() {
        return teamService.findAllTeams();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable Integer id){
        TeamDto team = teamService.findTeamById(id);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

//    @GetMapping("/list/{teamName}")
//    public ResponseEntity<TeamDto> getTeamByName(@PathVariable String teamName){
//
//        TeamDto team = teamService.findTeamByName(teamName);
//        return new ResponseEntity<>(team, HttpStatus.OK);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Integer id, @RequestBody Team team){
        teamService.updateCoach(id, team);
        log.warn("A team is updated");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
