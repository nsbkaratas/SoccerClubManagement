package com.soccerclub.trainingservice.service;

import com.soccerclub.trainingservice.exception.TrainingAlreadyExists;
import com.soccerclub.trainingservice.model.Training;
import com.soccerclub.trainingservice.repository.TrainingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nesibe karatas
 */
@Service
public class TrainingService {
    @Autowired
    private final TrainingRepo trainingRepo;

    public TrainingService(TrainingRepo trainingRepo) {
        this.trainingRepo = trainingRepo;
    }


    public Training save(Training newTraining) {
       return trainingRepo.save(newTraining);
    }

    public List<Training> findAll() {
        return trainingRepo.findAll();
    }
}
