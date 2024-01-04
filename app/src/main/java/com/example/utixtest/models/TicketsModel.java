package com.example.utixtest.models;

public class TicketsModel {

    private String title;
    private String time;
    private String seats;

    public TicketsModel(String title, String time, String seats) {
        this.title = title;
        this.time = time;
        this.seats = seats;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }
}
