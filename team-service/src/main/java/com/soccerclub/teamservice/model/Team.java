package com.soccerclub.teamservice.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NonNull
    @Column(name = "team_name", unique = true)
    String name;

    @NonNull
    @Column(name = "coach_id")
    int coachId;

    @NonNull
    @Column(name = "age_group")
    String ageGroup;

    @OneToMany(mappedBy = "team",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    List<Player> players;

}
