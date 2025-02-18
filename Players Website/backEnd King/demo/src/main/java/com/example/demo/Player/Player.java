package com.example.demo.Player;

import java.time.Instant;

public class Player {
    private Long id;
    private String name;
    private String status;
    private String description;
    private Integer delta;
    private String createdOn;

    public Player() {
    }

    public Player(Long id, String name, String status, String description, Integer delta, String createdOn) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.description = description;
        this.delta = delta;
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDelta() {
        return delta;
    }

    public void setDelta(Integer delta) {
        this.delta = delta;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", delta=" + delta +
                ", createdOn=" + createdOn +
                '}';
    }
}
