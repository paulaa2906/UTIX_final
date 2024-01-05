package com.example.utixtest.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utixtest.R;
import com.example.utixtest.adapter.RVHomeAdapter;
import com.example.utixtest.models.MovieModel;
import com.example.utixtest.request.GetServicesMovie;
import com.example.utixtest.response.MoviesResponse;
import com.example.utixtest.utils.Credentials;
import com.example.utixtest.utils.MovieAPI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment{
    private MovieAPI movieAPI;

    private RecyclerView rvHome;

    private RVHomeAdapter rvHomeAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvHome = view.findViewById(R.id.rv_home);
        rvHome.setHasFixedSize(true);
        rvHome.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        movieAPI = GetServicesMovie.getMovieAPI();
        Call<MoviesResponse> responseCall = movieAPI.getNowPlaying(
                Credentials.API_KEY,
                ""
        );

        responseCall.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if(response.isSuccessful()){
                    List<MovieModel> movies = new ArrayList<>(response.body().getResults());

                    generate_data(movies);


                }
                else {
                    try {
                        Log.d("Qiqi", "error: " + response.errorBody().string());
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

            }
        });
    }

    private void generate_data(List<MovieModel> movieModels){
        for (MovieModel movie : movieModels){
            Log.d("Qiqi", "Movie Title: " + movie.getTitle());
        }

        rvHome = rvHome.findViewById(R.id.rv_home);
        rvHomeAdapter = new RVHomeAdapter(movieModels, getActivity());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        rvHome.setLayoutManager(layoutManager);
        rvHome.setAdapter(rvHomeAdapter);
    }

}

