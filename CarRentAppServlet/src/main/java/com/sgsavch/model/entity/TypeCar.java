package com.sgsavch.model.entity;

public enum TypeCar {
    ANY, CABRIOLET, ELECTRIC, OFFROAD, WAGON, SEDAN, MINIBUS;
    public String getType() {
        return name();
    }
}
