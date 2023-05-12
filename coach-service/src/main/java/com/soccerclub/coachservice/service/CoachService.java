package com.soccerclub.coachservice.service;

import com.soccerclub.coachservice.controller.CoachController;
import com.soccerclub.coachservice.dto.CoachDTO;
import com.soccerclub.coachservice.dto.CoachCredentialDTO;
import com.soccerclub.coachservice.exception.CoachAlreadyExists;
import com.soccerclub.coachservice.exception.CoachIdNotFoundException;
import com.soccerclub.coachservice.exception.CoachUsernameNotFoundException;
import com.soccerclub.coachservice.model.Coach;
import com.soccerclub.coachservice.repository.CoachRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;


import java.util.stream.Collectors;

@Service
@Slf4j
public class CoachService {

    private final Path FOLDER_PATH = Paths.get("./coach-service/uploads/");

    private final CoachRepository coachRepository;
    private final CoachDTOMapper coachDTOMapper;
    private final CredentialDTOMapper credentialDTOMapper;


    public CoachService(CoachRepository coachRepository, CoachDTOMapper coachDTOMapper, CredentialDTOMapper credentialDTOMapper) {
        this.coachRepository = coachRepository;
        this.coachDTOMapper = coachDTOMapper;
        this.credentialDTOMapper = credentialDTOMapper;

    }


    public void saveCoach(Coach coach) {
        if(coachRepository.existsCoachByEmail(coach.getEmail())){
            throw new CoachAlreadyExists(coach.getEmail());
        }
        coachRepository.save(coach);
    }

    public List<CoachDTO> findAllCoach() {
        return coachRepository.findAll()
                .stream()
                .map(coachDTOMapper)
                .collect(Collectors.toList());
    }

    public CoachDTO findCoachById(Integer id) {
         return coachRepository.findById(id)
                .map(coachDTOMapper)
                .orElseThrow(() -> new CoachIdNotFoundException(id));


    }

    public void updateCoach(Integer id, Coach coach) {
        Coach coachToUpdate = coachRepository.findById(id).orElseThrow(()-> new CoachIdNotFoundException(id));
        coachToUpdate.setEmail(coach.getEmail());
        coachToUpdate.setFirstName(coach.getFirstName());
        coachToUpdate.setLastName(coach.getLastName());
        coachToUpdate.setPhoneNumber(coach.getPhoneNumber());
        coachToUpdate.setPassword(coach.getPassword());
        coachToUpdate.setGender(coach.getGender());
        coachToUpdate.setTeamIds(coach.getTeamIds());
        coachRepository.save(coachToUpdate);
    }

    public void uploadCoachProfileImage(Integer coachId, MultipartFile file)  {
        Coach coach = coachRepository.findById(coachId)
                .orElseThrow(()-> new CoachIdNotFoundException(coachId));

        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));


        String imageName = coach.getFirstName()
                .concat("_").concat(coach.getLastName()).concat(extension);

        Path path = this.FOLDER_PATH.resolve(imageName);

        try {
            Files.createDirectories(this.FOLDER_PATH);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        String urlProfileImage = MvcUriComponentsBuilder
                .fromMethodName(CoachController.class, "getProfileImage", path.getFileName().toString()).build().toString();


        coach.setProfileImageId(urlProfileImage);
        updateCoach(coach.getId(), coach);
        log.info("File uploaded successfully!");

    }

    public Resource getProfileImage(String fileName) {

        try {
            Path file = FOLDER_PATH.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }


    public CoachCredentialDTO findCoachByUsername(String username) {
        return coachRepository.findCoachByUsername(username)
                .map(credentialDTOMapper)
                .orElseThrow(() ->  new CoachUsernameNotFoundException(username));

    }
}
