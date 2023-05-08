package com.soccerclub.coachservice.service;

import com.soccerclub.coachservice.dto.TeamDto;
import org.springframework.cloud.openfeign.FeignClient;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(url = "http://localhost:8090", value = "team-service")
public interface TeamProxy {
//    @GetMapping("/team/list/{teamName}")
//    TeamDto getTeamByName(@PathVariable("teamName") String teamName);

    @GetMapping("/team/list/{id}")
    public TeamDto getTeamById(@PathVariable Integer id);
}
