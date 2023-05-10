package com.soccerclub.teamservice.dto;

import java.time.LocalDate;

public record PlayerDto(Integer id,
                        String firstName,
                        String lastName,
                        LocalDate dateOfBirth,
                        String teamName
) {
}
