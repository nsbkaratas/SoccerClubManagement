package com.soccerclub.coachservice.service;

import com.soccerclub.coachservice.dto.CoachCredentialDTO;
import com.soccerclub.coachservice.model.Coach;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CredentialDTOMapper implements Function<Coach, CoachCredentialDTO> {

    @Override
    public CoachCredentialDTO apply(Coach coach) {
        return new CoachCredentialDTO(
                coach.getUserName(),
                coach.getPassword()
        );
    }
}
