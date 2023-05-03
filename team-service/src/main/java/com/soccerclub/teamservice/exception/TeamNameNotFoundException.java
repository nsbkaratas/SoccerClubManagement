package com.soccerclub.teamservice.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class TeamNameNotFoundException extends RuntimeException {
    public TeamNameNotFoundException( String name){
        super("Team with name: "+ name + " is not found");

    }

}