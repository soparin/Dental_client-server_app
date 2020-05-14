package com.Menu;


public class PatientMenu {

    private String spec;
    private String surname;
    private String name;
    private String startDate;
    private String dateTicket;
    private String time;
    private String phone;

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public PatientMenu() {}

    public PatientMenu(String spec, String surname, String name, String startDate,
                       String dateTicket, String time, String phone) {
        this.spec = spec;
        this.surname = surname;
        this.name = name;
        this.startDate = startDate;
        this.dateTicket = dateTicket;
        this.time = time;
        this.phone = phone;
    }

}
