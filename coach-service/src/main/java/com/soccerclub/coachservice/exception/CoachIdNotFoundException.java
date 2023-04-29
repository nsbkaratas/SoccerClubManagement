package com.soccerclub.coachservice.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class CoachIdNotFoundException extends RuntimeException{
    public CoachIdNotFoundException(Integer id){
        super("Coach with id: "+ id + "is not found ");
    }
}
