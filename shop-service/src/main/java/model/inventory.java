package model;

import jakarta.persistence.Entity;

@Entity
public record inventory(int id, String name) {
}
