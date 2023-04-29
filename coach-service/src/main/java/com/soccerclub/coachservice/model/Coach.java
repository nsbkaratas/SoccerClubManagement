package com.soccerclub.coachservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nesibe karatas
 */
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor(force = true)
public class Coach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    String firstName;

    @NonNull
    String lastName;

    @NonNull
    String email;

    @NonNull
    String phoneNumber;

    @NonNull
    String userName;

    @NonNull
    String password;

     List<Team> teams= new ArrayList<>();


}
