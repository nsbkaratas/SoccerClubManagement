package com.soccerclub.trainingservice.repository;

import com.soccerclub.trainingservice.model.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

/**
 * @author nesibe karatas
 */
@Repository
public interface TrainingRepo extends JpaRepository<Training, Long> {
    Optional<Training> findTrainingByDate(LocalDate date);
}
