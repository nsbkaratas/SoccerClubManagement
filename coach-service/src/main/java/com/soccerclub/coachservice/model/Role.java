package com.soccerclub.coachservice.model;

public enum Role {
    COACH ("Coach"),
    ADMIN("Admin");

    private final String role;
    Role(String role){
        this.role= role;
    }

    public String getRole(){
        return role;
    }
}
