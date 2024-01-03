package com.example.utixtest.models;

import com.google.gson.annotations.SerializedName;

public class MovieModel {

    @SerializedName("title")
    private String title;

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("release_date")
    private String release_date;

    @SerializedName("overview")
    private String movie_overview;

    @SerializedName("id")
    private int movie_id;

    @SerializedName("vote_average")
    private float vote_average;

    @SerializedName("popularity")
    private float popularity;


    //constructor

    public MovieModel(String title, String poster_path, String release_date, String movie_overview, int movie_id, float vote_average, float popularity) {
        this.title = title;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.movie_overview = movie_overview;
        this.movie_id = movie_id;
        this.vote_average = vote_average;
        this.popularity = popularity;
    }


    //getter setter

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
