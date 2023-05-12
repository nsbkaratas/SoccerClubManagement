package com.soccerclub.securityservice.service;

import com.soccerclub.securityservice.dto.CoachCredentialDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(url = "http://localhost:8098", value = "coach-service")
public interface CoachProxy {
    @GetMapping("/validate/{username}")
    public CoachCredentialDTO getCoachCredentials(@PathVariable String username);
}
