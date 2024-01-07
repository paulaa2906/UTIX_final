package com.example.utixtest.models;

public class TicketsModel {

    private String title;

    private String date;
    private String time;
    private String seats;

    public TicketsModel(String title, String date, String time, String seats) {
        this.title = title;
        this.time = time;
        this.seats = seats;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
