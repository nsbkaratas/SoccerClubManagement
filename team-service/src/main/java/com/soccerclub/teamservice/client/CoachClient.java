package com.soccerclub.teamservice.client;

import com.soccerclub.teamservice.dto.CoachDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "coach-service", url = "${application.config.coach-url}")
public interface CoachClient {
    @GetMapping("/{id}")
    public CoachDto findCoachById(@PathVariable Integer id);
}
