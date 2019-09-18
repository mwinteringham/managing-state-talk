package com.automationintesting.e5databuilder.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingRequestModel {

//    return new BookingRequestModel(1, "Mark", "Winteringham", true, "mark@testemail.com", "01928129825", bookingDatesModel);

    @JsonProperty
    private int roomid;
    @JsonProperty
    private String firstname;
    @JsonProperty
    private String lastname;
    @JsonProperty
    private boolean depositpaid;
    @JsonProperty
    private String email;
    @JsonProperty
    private String phone;
    @JsonProperty
    private BookingDatesModel bookingdates;

    public BookingRequestModel(int roomid, String firstname, String lastname, boolean depositpaid, String email, String phone, BookingDatesModel bookingdates) {
        this.roomid = roomid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.depositpaid = depositpaid;
        this.email = email;
        this.phone = phone;
        this.bookingdates = bookingdates;
    }

    public int getRoomid() {
        return roomid;
    }

    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public BookingDatesModel getBookingdates() {
        return bookingdates;
    }

    public void setBookingdates(BookingDatesModel bookingdates) {
        this.bookingdates = bookingdates;
    }
}
