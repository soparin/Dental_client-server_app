package com.Menu;

public class DentistMenu {

    private String id;
    private String date;
    private String time;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public DentistMenu(String date, String time, String phone) {
        this.date = date;
        this.time = time;
        this.phone = phone;
    }

    public DentistMenu() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
}
