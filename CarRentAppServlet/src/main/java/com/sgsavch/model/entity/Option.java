package com.sgsavch.model.entity;
import lombok.*;


import javax.persistence.*;


public class Option {
    private Long id;
    private String name;
    private String picture;
    private String description;
    private Double price;
    private Order currentOrder;

    public Option() {
    }

    public Option(Long id,
                  String name,
                  String picture,
                  String description,
                  Double price,
                  Order currentOrder) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.price = price;
        this.currentOrder = currentOrder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public void setCurrentOrder(Order currentOrder) {
        this.currentOrder = currentOrder;
    }
}