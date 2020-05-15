package com.Menu;


public class PatientMenu {

    private String spec;
    private String surnamename;
    private String startDate;
    private String dateTicket;
    private String time;
    private String phone;

    public PatientMenu(String spec, String surnamename, String startDate, String dateTicket,
                       String time, String phone) {
        this.spec = spec;
        this.surnamename = surnamename;
        this.startDate = startDate;
        this.dateTicket = dateTicket;
        this.time = time;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PatientMenu{" +
                "spec='" + spec + '\'' +
                ", surnamename='" + surnamename + '\'' +
                ", startDate='" + startDate + '\'' +
                ", dateTicket='" + dateTicket + '\'' +
                ", time='" + time + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSurnamename() {
        return surnamename;
    }

    public void setSurnamename(String surnamename) {
        this.surnamename = surnamename;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDateTicket() {
        return dateTicket;
    }

    public void setDateTicket(String dateTicket) {
        this.dateTicket = dateTicket;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PatientMenu() {
    }
}
