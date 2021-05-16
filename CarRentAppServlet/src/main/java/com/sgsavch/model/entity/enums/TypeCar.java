package com.sgsavch.model.entity.enums;

public enum TypeCar {
    ANY, CABRIOLET, ELECTRIC, OFFROAD, WAGON, SEDAN, MINIBUS;
    public String getType() {
        return name();
    }
}
