package com.sgsavch.model.entity.enums;

public enum Role {
    UNKNOWN, UNCONFIRMED, USER, ADMIN, CANDIDATE, SPEAKER, MANAGER;
        public String getRole() {
            return name();
        }
    }