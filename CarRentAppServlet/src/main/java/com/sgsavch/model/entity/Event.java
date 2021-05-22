package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.Language;
import com.sgsavch.model.entity.enums.StatusEvent;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;


public class Event {

    private Long id;
    private String name;
    private LocalDate date;
    private LocalTime time;
    private Language language;
    private Double price;
    private String description;
    private String picture;
    private StatusEvent statusEvent;

    public Event() {
    }

    public Event(Long id,
                 String name,
                 LocalDate date,
                 LocalTime time,
                 Language language,
                 Double price,
                 String description,
                 String picture,
                 StatusEvent statusEvent) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.language = language;
        this.price = price;
        this.description = description;
        this.picture = picture;
        this.statusEvent = statusEvent;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public StatusEvent getStatusEvent() {
        return statusEvent;
    }

    public void setStatusEvent(StatusEvent statusEvent) {
        this.statusEvent = statusEvent;
    }

}