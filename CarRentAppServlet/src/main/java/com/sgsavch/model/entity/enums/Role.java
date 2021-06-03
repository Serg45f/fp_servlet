package com.sgsavch.model.entity.enums;

public enum Role {
    UNKNOWN, UNCONFIRMED, USER, ADMIN,MANAGER;
        public String getRole() {
            return name();
        }
    }