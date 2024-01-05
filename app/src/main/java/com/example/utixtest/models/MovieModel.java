package com.example.utixtest.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MovieModel implements Serializable {

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("overview")
    private String movie_overview;

    @SerializedName("backdrop_path")
    private String backdrop_path;

    @SerializedName("id")
    private int movie_id;

    @SerializedName("vote_average")
    private float vote_average;

    @SerializedName("popularity")
    private float popularity;


    //constructor

    public MovieModel(String title, String poster_path, String release_date, String movie_overview, String backdrop_path, int movie_id, float vote_average, float popularity) {
        this.title = title;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.movie_overview = movie_overview;
        this.backdrop_path = backdrop_path;
        this.movie_id = movie_id;
        this.vote_average = vote_average;
        this.popularity = popularity;
    }


    //getter setter


    public void setTitle(String title) {
        this.title = title;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setMovie_overview(String movie_overview) {
        this.movie_overview = movie_overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public String getTitle() {
        return title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getMovie_overview() {
        return movie_overview;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public float getVote_average() {
        return vote_average;
    }
}
