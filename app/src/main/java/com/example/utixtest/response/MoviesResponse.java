package com.example.utixtest.response;

import com.example.utixtest.models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesResponse {
    @SerializedName("page")
    @Expose()
    private int page;
    @SerializedName("results")
    @Expose()
    private List<MovieModel> results;
    @SerializedName("total_results")
    @Expose()
    private int total_count;
    @SerializedName("total_pages")
    @Expose()
    private int total_pages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieModel> getResults() {
        return results;
    }

    public void setMovies(List<MovieModel> movies) {
        this.results = results;
    }

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public int getTotal_page() {
        return total_pages;
    }

    public void setTotal_page(int total_page) {
        this.total_pages = total_pages;
    }

    @Override
    public String toString() {
        return "MoviesResponse{" +
                "page=" + page +
                ", results=" + results +
                ", total_count=" + total_count +
                ", total_page=" + total_pages +
                '}';
    }
}
