package com.soccerclub.coachservice.controller;

import com.soccerclub.coachservice.dto.CoachDTO;
import com.soccerclub.coachservice.model.Coach;
import com.soccerclub.coachservice.repository.CoachRepository;
import com.soccerclub.coachservice.service.CoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {


    private static final Logger LOGGER = LoggerFactory.getLogger(CoachController.class);
    @Autowired
    private CoachService coachService;


    @PostMapping("/save")
    public ResponseEntity<?> saveCoach(@RequestBody Coach coach){
        System.out.println("inside saveCoach");
        coachService.saveCoach(coach);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @GetMapping("/list")
    public List<CoachDTO> getCoaches() {
        return coachService.findAllCoach();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoachDTO> findCoachById(@PathVariable Integer id){
        CoachDTO coach = coachService.findCoachById(id);
        return new ResponseEntity<>(coach, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCoach(@PathVariable Integer id, @RequestBody Coach coach){
        coachService.updateCoach(id, coach);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(
            value = "{coachId}/profile-image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public void uploadCoachProfileImage(
            @PathVariable("coachId") Integer coachId,
            @RequestParam("file") MultipartFile file) {
        coachService.uploadCoachProfileImage(coachId, file);
    }

    @GetMapping("/profile-image/{fileName}")
    public ResponseEntity<Resource> getProfileImage(@PathVariable("fileName") String fileName) throws IOException {

        Resource resource =coachService.getProfileImage(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename="+fileName).body(resource);

    }



}
