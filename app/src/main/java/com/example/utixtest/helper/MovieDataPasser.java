package com.example.utixtest.helper;

public class MovieDataPasser {

    private static MovieDataPasser instance;
    private String movieTitle;

    private String poster_path;

    private MovieDataPasser(){}

    public static MovieDataPasser getInstance(){
        if(instance == null){
            instance = new MovieDataPasser();
        }

        return instance;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
