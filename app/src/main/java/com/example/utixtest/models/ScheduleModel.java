package com.example.utixtest.models;

import java.util.ArrayList;

public class ScheduleModel {

    private String mallName;
    private String cinemaType;
    private int price;
    private ArrayList<String> timeList = new ArrayList<>();

    public ScheduleModel(String mallName, String cinemaType, int price, ArrayList<String> timeList) {
        this.mallName = mallName;
        this.cinemaType = cinemaType;
        this.price = price;
        this.timeList = timeList;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getCinemaType() {
        return cinemaType;
    }

    public void setCinemaType(String cinemaType) {
        this.cinemaType = cinemaType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<String> getTimeList() {
        return timeList;
    }

    public void setTimeList(ArrayList<String> timeList) {
        this.timeList = timeList;
    }
}
