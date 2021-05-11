package com.sgsavch.model.entity.enums;

public enum Hall {
    GRAND(200), SMALL(50), GREEN(80), RED(100), BLUE(150);

    private int capacity;

    Hall(int capacity) {
        this.capacity = capacity;
    }

    public String getHall() {
        return name();
    }

    public int placesLeft(int placesOcupied) {
        if (capacity < placesOcupied)
            throw new IllegalArgumentException("Number is bigger then hall capacity");
        return capacity - placesOcupied;
    }

    public boolean isPlaces(int boughtPlaces) {
        if (capacity < boughtPlaces)
            throw new IllegalArgumentException("Number is bigger then hall capacity");
        if (capacity - boughtPlaces > 0) return true;
        return false;
    }
    public int getId(){return ordinal();}

}
