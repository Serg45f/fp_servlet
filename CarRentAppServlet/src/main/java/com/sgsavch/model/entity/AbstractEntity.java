package com.sgsavch.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;


public abstract class AbstractEntity implements Serializable {
    Long id;
    LocalDateTime created;
    LocalDateTime updated;

    public AbstractEntity(Long id, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.created = created;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }



    public void toCreate() {
        setCreated(LocalDateTime.now());
    }

    public void toUpdate() {
        setUpdated(LocalDateTime.now());
    }
}
