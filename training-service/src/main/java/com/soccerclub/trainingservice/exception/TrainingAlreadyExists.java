package com.soccerclub.trainingservice.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author nesibe karatas
 */
@ResponseStatus(code =  HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class TrainingAlreadyExists extends RuntimeException{
    public TrainingAlreadyExists(LocalDate date, LocalTime time,  String fieldName){
        super("Training in field " + fieldName+" at "+ time + " on "+ date+" already exists.");

    }

}
