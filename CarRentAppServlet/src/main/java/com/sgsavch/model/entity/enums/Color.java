package com.sgsavch.model.entity.enums;

public enum Color {
    ANY, WHITE, BLACK, RED, YELLOW, BLUE;
    public String getColor() {
        return name();
    }
    public int getId(){return ordinal();}
}
