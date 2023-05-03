package com.soccerclub.teamservice.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class TeamIdNotFoundException extends RuntimeException {
    public TeamIdNotFoundException( Integer id){
        super("Team with id: "+ id + " is not found");

    }

}
