package com.soccerclub.coachservice.service;

import com.soccerclub.coachservice.dto.TeamDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8090", value = "team-service")
public interface TeamProxy {
    @GetMapping("api/teams/{teamName}")
    TeamDto getTeamByName(@PathVariable("teamName") String teamName);
}
