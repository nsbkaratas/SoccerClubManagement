package com.soccerclub.coachservice.dto;

import com.soccerclub.coachservice.model.Team;

import java.util.List;

public record CoachDTO(
        Integer id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String username,
        String gender,
        String profileImageId
       // List<String> teams
) {

}
