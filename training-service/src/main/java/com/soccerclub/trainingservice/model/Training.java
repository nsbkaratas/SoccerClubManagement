package com.soccerclub.trainingservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.time.temporal.TemporalAmount;

/**
 * @author nesibe karatas
 */

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    LocalTime startTime;

    @NonNull
    String duration;

    @NonNull
    String fieldName;

    @NonNull
    String teamName;//should be refactored once relationship is defined

}
