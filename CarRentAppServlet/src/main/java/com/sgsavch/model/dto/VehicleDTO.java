package com.sgsavch.model.dto;

import com.sgsavch.model.entity.CarModel;
import com.sgsavch.model.entity.Option;
import com.sgsavch.model.entity.Order;
import com.sgsavch.model.entity.User;
import com.sgsavch.model.entity.enums.Color;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class VehicleDTO {
    private Long id;
    private Long carModelId;
    private String regNumber;
    private LocalDate yearIssue;
    private List<Order> orders;
    private Integer colorId;
    private String transmission;
    private Double discount = 0D;
    private Long managerId;
    private Boolean isNew;

    public VehicleDTO() {
    }

    public VehicleDTO(Long id,
                   Long carModelId,
                   String regNumber,
                   LocalDate yearIssue,
                   List<Order> orders,
                   Integer colorId,
                   String transmission,
                   Double discount,
                   Long managerId,
                   Boolean isNew) {

        this.id = id;
        this.carModelId = carModelId;
        this.regNumber = regNumber;
        this.yearIssue = yearIssue;
        this.orders = orders;
        this.colorId = colorId;
        this.transmission = transmission;
        this.discount = discount;
        this.managerId = managerId;
        this.isNew = isNew;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarModelId() {
        return carModelId;
    }

    public void setCarModelId(Long carModelId) {
        this.carModelId = carModelId;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public LocalDate getYearIssue() {
        return yearIssue;
    }

    public void setYearIssue(LocalDate yearIssue) {
        this.yearIssue = yearIssue;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Long getManagerId() {
        return managerId;
    }

    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    public Boolean getNew() {
        return isNew;
    }

    public void setNew(Boolean aNew) {
        isNew = aNew;
    }

    public VehicleDTO extractFromRequest(HttpServletRequest request) throws SQLException {
        VehicleDTO vehicleDTO = new VehicleDTO();
        if(request.getParameter("id")!=null) vehicleDTO.setId(Long.valueOf(request.getParameter("id")));
        if(request.getParameter("regNumber")!=null) vehicleDTO.setRegNumber(request.getParameter("regNumber"));
        if(request.getParameter("yearIssue")!=null) vehicleDTO.setYearIssue(LocalDate.parse(request.getParameter("yearIssue")));
        if(request.getParameter("color")!=null) vehicleDTO.setColorId(Integer.valueOf(request.getParameter("color")));
        if(request.getParameter("transmission")!=null) vehicleDTO.setTransmission(request.getParameter("transmission"));
        if(request.getParameter("discount")!=null) vehicleDTO.setDiscount(Double.valueOf(request.getParameter("discount")));
        if(request.getParameter("manager")!=null) vehicleDTO.setManagerId(Long.valueOf(request.getParameter("manager")));
        if(request.getParameter("isNew")!=null) vehicleDTO.setNew(Boolean.valueOf(request.getParameter("isNew")));

        return vehicleDTO;
    }
}
