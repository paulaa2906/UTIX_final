package com.example.utixtest.response;

import com.example.utixtest.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieResponse {
    @SerializedName("result")
    @Expose()
    private MovieModel movie;

    public MovieModel getMovieModel(){
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movieModel=" + movie +
                '}';
    }
}
