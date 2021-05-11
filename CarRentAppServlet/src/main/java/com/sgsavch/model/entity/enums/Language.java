package com.sgsavch.model.entity.enums;

public enum Language {
    EN, RU, UA;

    public String getLanguage() {
        return name();
    }
    public int getId(){return ordinal();}
}
