package com.sgsavch.model.entity.enums;

public enum Country {
    Ukraine, USA, Belarus, EU, Georgia;

    public String getCountry() {
        return name();
    }
    public int getId(){return ordinal();}
}
