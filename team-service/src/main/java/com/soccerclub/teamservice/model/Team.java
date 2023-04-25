package com.soccerclub.teamservice.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cache;

import java.util.ArrayList;
import java.util.List;
@Table(name="teams")
@NoArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Team {
    @Id
    @Column(name="team_id")
    int id;

    @NonNull
    @Column(name = "team_name")
    String name;

    @NonNull
    @Column(name = "coach_name")
    String coachName;

    @NonNull
    @Column(name = "age_group")
    String ageGroup;

    @OneToMany(mappedBy = "team",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    List<Player> players;




}