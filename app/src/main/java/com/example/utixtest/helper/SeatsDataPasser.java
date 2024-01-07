package com.example.utixtest.helper;

public class SeatsDataPasser {

    private static SeatsDataPasser instance;

    private String seats_date;
    private String seats_time;
    private String seats_qty;
    private String seats_price;
    private String seats_total_price;

    private String seats_num;

    public static SeatsDataPasser getInstance(){
        if(instance == null){
            instance = new SeatsDataPasser();
        }

        return instance;
    }

    public String getSeats_num() {
        return seats_num;
    }

    public void setSeats_num(String seats_num) {
        this.seats_num = seats_num;
    }

    public String getSeats_date() {
        return seats_date;
    }

    public void setSeats_date(String seats_date) {
        this.seats_date = seats_date;
    }

    public String getSeats_time() {
        return seats_time;
    }

    public void setSeats_time(String seats_time) {
        this.seats_time = seats_time;
    }

    public String getSeats_qty() {
        return seats_qty;
    }

    public void setSeats_qty(String seats_qty) {
        this.seats_qty = seats_qty;
    }

    public String getSeats_price() {
        return seats_price;
    }

    public void setSeats_price(String seats_price) {
        this.seats_price = seats_price;
    }

    public String getSeats_total_price() {
        return seats_total_price;
    }

    public void setSeats_total_price(String seats_total_price) {
        this.seats_total_price = seats_total_price;
    }
}
