package com.pitchmind.dtos;


public class PitchRequest {
    private String description;

    public PitchRequest() {
    }

    public PitchRequest(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}