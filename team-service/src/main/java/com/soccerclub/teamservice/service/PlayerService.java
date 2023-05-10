package com.soccerclub.teamservice.service;

import com.soccerclub.teamservice.dto.PlayerDto;

import com.soccerclub.teamservice.model.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@Slf4j
@RequestMapping("/team/player")
public class PlayerService {
    public void savePlayer(Player player) {
    }

    public List<PlayerDto> findAllPlayers() {
        return null;
    }

    public PlayerDto findPlayerById(Integer id) {
        return null;
    }

    public List<PlayerDto> findPlayersByTeam(String teamName) {
        return null;
    }

    public void updatePlayer(Integer id, Player player) {
    }
}
