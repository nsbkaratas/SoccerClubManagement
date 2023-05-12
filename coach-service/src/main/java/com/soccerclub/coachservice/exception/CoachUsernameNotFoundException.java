package com.soccerclub.coachservice.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class CoachUsernameNotFoundException extends RuntimeException{
    public CoachUsernameNotFoundException(String username){
        super("Coach with username: "+ username + "is not found ");
    }
}
