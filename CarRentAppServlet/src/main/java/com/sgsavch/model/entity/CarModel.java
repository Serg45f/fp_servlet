package com.sgsavch.model.entity;

import com.sgsavch.model.entity.enums.StatusCar;
import com.sgsavch.model.entity.enums.TypeCar;

import java.util.List;

public class CarModel {
    private Long id;
    private String name;
    private Integer seatsNumb;
    private Integer doorsNumb;
    private String picture;
    private TypeCar type;
    private StatusCar status;
    private Double price;
    private Double deposit;
    private List<Vehicle> vehicles;

    public CarModel() {
    }

    public CarModel(Long id,
                    String name,
                    Integer seatsNumb,
                    Integer doorsNumb,
                    String picture,
                    TypeCar type,
                    StatusCar status,
                    Double price,
                    Double deposit,
                    List<Vehicle> vehicles) {
        this.id = id;
        this.name = name;
        this.seatsNumb = seatsNumb;
        this.doorsNumb = doorsNumb;
        this.picture = picture;
        this.type = type;
        this.status = status;
        this.price = price;
        this.deposit = deposit;
        this.vehicles = vehicles;
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

    public Integer getSeatsNumb() {
        return seatsNumb;
    }

    public void setSeatsNumb(Integer seatsNumb) {
        this.seatsNumb = seatsNumb;
    }

    public Integer getDoorsNumb() {
        return doorsNumb;
    }

    public void setDoorsNumb(Integer doorsNumb) {
        this.doorsNumb = doorsNumb;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public TypeCar getType() {
        return type;
    }

    public void setType(TypeCar type) {
        this.type = type;
    }

    public StatusCar getStatus() {
        return status;
    }

    public void setStatus(StatusCar status) {
        this.status = status;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public String toString(){
        return new StringBuilder("CarModel(")
                .append("id=")
                .append(id)
                .append(", ")
                .append("name=")
                .append(name)
                .append(", ")
                .append("seatsNumb=")
                .append(seatsNumb)
                .append(", ")
                .append("doorsNumb=")
                .append(doorsNumb)
                .append(", ")
                .append("picture=")
                .append(picture)
                .append(", ")
                .append("type=")
                .append(type)
                .append(", ")
                .append("status=")
                .append(status)
                .append(", ")
                .append("price=")
                .append(price)
                .append(", ")
                .append("deposit=")
                .append(deposit)
                .append(")")
                .toString();
    }

}