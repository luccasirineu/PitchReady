package com.pitchmind.models;

import com.pitchmind.dtos.PitchRequest;
import com.pitchmind.dtos.PitchResponse;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Pitch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private String response;
    private LocalDateTime dateTime;

    public Pitch() {

    }

    public Pitch(Long id, String description, String response, LocalDateTime dateTime) {
        this.id = id;
        this.description = description;
        this.response = response;
        this.dateTime = dateTime;
    }

    public Pitch(String description, PitchResponse response, LocalDateTime localDateTime) {

        this.description = description;
        this.response = response.getResponse();
        this.dateTime = localDateTime;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
