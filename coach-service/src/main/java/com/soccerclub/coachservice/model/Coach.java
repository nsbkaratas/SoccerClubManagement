package com.soccerclub.coachservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

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
public class Coach implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NonNull
    String firstName;

    @NonNull
    String lastName;

    @NonNull
    String email;

    @NonNull
    @Digits(fraction = 0, integer = 12)
    String phoneNumber;

    @NonNull
    String userName;

    @NonNull
    String password;

    @NonNull
    @Transient
    String confirmPassword;
    @Enumerated(EnumType.STRING)
    Gender gender;
    @Column(unique = true)
    String profileImageId;

     List<Integer> teamIds= new ArrayList<>();

    @Enumerated(EnumType.STRING)
    Set<Role> role= new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
