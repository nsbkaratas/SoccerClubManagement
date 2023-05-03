package com.soccerclub.teamservice.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class TeamAlreadyExists extends RuntimeException{
    public TeamAlreadyExists(String name){
        super("Team with name: "+ name + " already exists");

    }
}