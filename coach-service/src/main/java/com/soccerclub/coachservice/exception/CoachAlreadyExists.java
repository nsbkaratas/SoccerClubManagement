package com.soccerclub.coachservice.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class CoachAlreadyExists extends RuntimeException{
    public CoachAlreadyExists(String email){
        super("Coach with email: "+ email + " already exists");

    }
}
