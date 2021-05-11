package com.sgsavch.model.entity.enums;

public enum Theme {
    IT, LOGISTICS, CONSTRUCTION, ENGINEERING, AGRICULTURE;

    public String getTheme() {
        return name();
    }
    public int getId(){return ordinal();}
}
