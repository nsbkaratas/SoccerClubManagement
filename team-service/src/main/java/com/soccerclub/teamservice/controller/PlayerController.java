package com.soccerclub.teamservice.controller;

import com.soccerclub.teamservice.dto.PlayerDto;
import com.soccerclub.teamservice.dto.TeamDto;
import com.soccerclub.teamservice.model.Player;
import com.soccerclub.teamservice.model.Team;
import com.soccerclub.teamservice.service.PlayerService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
@RequestMapping("/player")
public class PlayerController {
    private final PlayerService playerService;

    @PostMapping("/save")
    public ResponseEntity<?> savePlayer(@RequestBody Player player){

        playerService.savePlayer(player);
        log.warn("A player is created");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/list/all")
    public List<PlayerDto> getPlayers() {
        return playerService.findAllPlayers();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Integer id){
        PlayerDto player = playerService.findPlayerById(id);
        return new ResponseEntity<>(player, HttpStatus.OK);
    }

    @GetMapping("/list/{teamName}")
    public ResponseEntity<List<PlayerDto>> getPlayersByTeamName(@PathVariable String teamName){

        List<PlayerDto> players = playerService.findPlayersByTeam(teamName);
        return new ResponseEntity<>(players, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePlayer(@PathVariable Integer id, @RequestBody Player player){
        playerService.updatePlayer(id, player);
        log.warn("A player is updated");
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
