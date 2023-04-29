package com.soccerclub.coachservice.controller;

import com.soccerclub.coachservice.model.Coach;
import com.soccerclub.coachservice.repository.CoachRepository;
import com.soccerclub.coachservice.service.CoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {


    private static final Logger LOGGER = LoggerFactory.getLogger(CoachController.class);
    @Autowired
    private CoachService coachService;


    @PostMapping("/save")
    public ResponseEntity<Coach> saveCoach(@RequestBody Coach coach){
        Coach savedCoach = coachService.saveCoach(coach);
        return new ResponseEntity<>(savedCoach, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Coach>> findAllCoach(){
        List<Coach> coaches = coachService.findAllCoach();
        return new ResponseEntity<>(coaches, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> findCoachById(@PathVariable Integer id){
        Coach coach = coachService.findCoachById(id);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable Integer id, @RequestBody Coach coach){
        Coach coachUpdated = coachService.updateCoach(id, coach);


        return new ResponseEntity<>(coachUpdated, HttpStatus.OK);
    }

}
