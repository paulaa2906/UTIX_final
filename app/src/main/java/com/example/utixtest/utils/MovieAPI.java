package com.example.utixtest.utils;

import com.example.utixtest.models.MovieModel;
import com.example.utixtest.response.MoviesResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieAPI {

    //search movies
    @GET("/3/search/movie")
    Call<MoviesResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") int page
    );

    //movie by id
    @GET("/3/movie/{movie_id}")
    Call<MovieModel> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );

    //now playing movie
    @GET("/3/movie/now_playing")
    Call<MoviesResponse> getNowPlaying(
            @Query("api_key") String key
//            @Query("page") int page
    );


}
