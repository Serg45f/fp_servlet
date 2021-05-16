package com.sgsavch.model.entity.agregates;


import com.sgsavch.model.entity.enums.Language;

import java.time.LocalDate;
import java.time.LocalTime;


public class TicketsCountAndTotalSum {
    private LocalDate eventDate;
    private LocalTime eventTime;
    private Language eventLanguage;
    private Double eventPrice;
    //private Hall eventPlace;
    private Long eventId;
    private String eventName;
    private String ticketCode;
    private Long userId;
    private String userEmail;
    private String userFirstName;
    private String userLastName;
    private Long tQuantity;
    private Double eSum;

    public TicketsCountAndTotalSum() {

    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalTime eventTime) {
        this.eventTime = eventTime;
    }

    public Language getEventLanguage() {
        return eventLanguage;
    }

    public void setEventLanguage(Language eventLanguage) {
        this.eventLanguage = eventLanguage;
    }

    public Double getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(Double eventPrice) {
        this.eventPrice = eventPrice;
    }

//    public Hall getEventPlace() {
//        return eventPlace;
//    }
//
//    public void setEventPlace(Hall eventPlace) {
//        this.eventPlace = eventPlace;
//    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String usersEmail) {
        this.userEmail = userEmail;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUsersLastName(String usersLastName) {
        this.userLastName = usersLastName;
    }

    public Long gettQuantity() {
        return tQuantity;
    }

    public void settQuantity(Long tQuantity) {
        this.tQuantity = tQuantity;
    }

    public Double geteSum() {
        return eSum;
    }

    public void seteSum(Double eSum) {
        this.eSum = eSum;
    }
}
