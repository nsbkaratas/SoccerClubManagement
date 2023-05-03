package com.soccerclub.teamservice.dto;

import java.util.List;

public record CoachDto(
        Integer id,
        String firstName,
        String lastName,
        String email,
        String phoneNumber,
        String username,
        String gender,
        String profileImageId,
        List<Integer> teamIds
) {

}
