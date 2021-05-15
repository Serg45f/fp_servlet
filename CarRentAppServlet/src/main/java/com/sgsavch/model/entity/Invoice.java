package com.sgsavch.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Invoice {
    private Long id;
    private Long number;
    private Order order;
    private boolean isPayed;
    private LocalDateTime paymentDate;

    public Invoice() {
    }

    public Invoice(Long id,
                   Long number,
                   Order order,
                   boolean isPayed,
                   LocalDateTime paymentDate) {
        this.id = id;
        this.number = number;
        this.order = order;
        this.isPayed = isPayed;
        this.paymentDate = paymentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }
}