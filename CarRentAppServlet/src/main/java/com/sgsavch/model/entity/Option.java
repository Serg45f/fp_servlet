package com.sgsavch.model.entity;
import lombok.*;


import javax.persistence.*;


public class Option {
    private final Long id;
    private final String name;
    private final String picture;
    private final String description;
    private final Double price;
    private final Order currentOrder;

    public Option(final Long id,
                  final String name,
                  final String picture,
                  final String description,
                  final Double price,
                  final Order currentOrder) {
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

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public static class Builder {

        private Long id;
        private String name;
        private String picture;
        private String description;
        private Double price;
        private Order currentOrder;

        public Builder() {
        }

        public Builder setId(Long id) {
            this.id = id;

            return this;
        }

        public Builder setName(String name) {
            this.name = name;

            return this;
        }

        public Builder setPicture(String picture) {
            this.picture = picture;

            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;

            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;

            return this;
        }

        public Builder setOrder(Order currentOrder) {
            this.currentOrder = currentOrder;

            return this;
        }

        public Option build() {
            return new Option(
                    id,
                    name,
                    picture,
                    description,
                    price,
                    currentOrder);
        }

    }
}