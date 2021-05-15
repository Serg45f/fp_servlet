package com.sgsavch.model.entity.enums;

public enum StatusCar {
    ANY, BUDGET, STANDARD, LUX, PREMIUM;
    public String getStatus() {
        return name();
    }
}
