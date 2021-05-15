package com.sgsavch.model.entity;

public enum Location {
    ODESSA("Odessa, International airport 'Odessa'"),
    KIEV("Kiev, International airport 'Jhulyany'");
    private final String address;
    Location(String address){
        this.address = address;
    }
    public String getLocation() {
        return name();
    }
    public String getAddress() {
        return address;
    }
}
