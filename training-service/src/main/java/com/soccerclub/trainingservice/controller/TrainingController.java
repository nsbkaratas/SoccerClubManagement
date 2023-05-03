package com.soccerclub.trainingservice.controller;

import com.soccerclub.trainingservice.model.Training;
import com.soccerclub.trainingservice.repository.TrainingRepo;
import com.soccerclub.trainingservice.service.TrainingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author nesibe karatas
 */

@RestController
@RequestMapping("/training")
public class TrainingController {
    private static final Logger LOGGER= LoggerFactory.getLogger(TrainingController.class);


    @Autowired
    private TrainingService trainingService;

    @PostMapping()
    Training training(@RequestBody Training newTraining){
        return trainingService.save(newTraining);
    }
    @GetMapping("/trainings")
    List<Training> trainings(){
        return trainingService.findAll();
    }


}

