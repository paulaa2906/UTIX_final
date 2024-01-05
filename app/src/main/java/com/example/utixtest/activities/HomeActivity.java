package com.example.utixtest.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.utixtest.R;
import com.example.utixtest.fragments.FragmenTicket;
import com.example.utixtest.fragments.FragmentAccount;
import com.example.utixtest.fragments.FragmentHome;
import com.example.utixtest.models.MovieModel;
import com.example.utixtest.request.GetServicesMovie;
import com.example.utixtest.response.MoviesResponse;
import com.example.utixtest.utils.Credentials;
import com.example.utixtest.utils.MovieAPI;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationView;

    private FragmentManager fragmentManager = getSupportFragmentManager();

    private Fragment homeFragment = new FragmentHome();

    private Fragment accountFragment = new FragmentAccount();

    private Fragment ticketFragment = new FragmenTicket();

    private Fragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        navigationView = findViewById(R.id.navigation);

        navigationView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        fragmentManager.beginTransaction().add(R.id.fragment_container_main, homeFragment)
                .hide(homeFragment).commit();

        fragmentManager.beginTransaction().add(R.id.fragment_container_main, accountFragment)
                .hide(accountFragment).commit();

        fragmentManager.beginTransaction().add(R.id.fragment_container_main, ticketFragment)
                .hide(ticketFragment).commit();

        activeFragment = homeFragment;
}


    private void GetRseponseSearch() {
        MovieAPI movieAPI = GetServicesMovie.getMovieAPI();

        Call<MoviesResponse> responseCall = movieAPI.searchMovie(
                Credentials.API_KEY,
                "Aquaman",
                1
        );

        responseCall.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.isSuccessful()){
                    Log.d("Qiqi", "Response: " + response.body().toString());

                    List<MovieModel> movies = new ArrayList<>(response.body().getResults());

                    for (MovieModel movie : movies){
                        Log.d("Qiqi", "Movie Title: " + movie.getTitle());
                    }
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
                t.printStackTrace();
            }
        });
    }

    private void GetResponseNowPlaying(){
        MovieAPI movieAPI = GetServicesMovie.getMovieAPI();

        Call<MoviesResponse> responseCall = movieAPI.getNowPlaying(
                Credentials.API_KEY,
                ""
        );

        responseCall.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                if (response.isSuccessful()){
                    Log.d("Qiqi", "Response: " + response.body().toString());

                    List<MovieModel> movies = new ArrayList<>(response.body().getResults());

                    for (MovieModel movie : movies){
                        Log.d("Qiqi", "Movie Title: " + movie.getTitle());
                    }
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
                t.printStackTrace();
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.navigation_bar_home){
            fragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(homeFragment)
                    .commit();
            activeFragment = homeFragment;
        } else if (item.getItemId() == R.id.navigation_bar_account) {
            fragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(accountFragment)
                    .commit();
            activeFragment = accountFragment;
        } else if (item.getItemId() == R.id.navigation_bar_ticket) {
            fragmentManager.beginTransaction()
                    .hide(activeFragment)
                    .show(ticketFragment)
                    .commit();
            activeFragment = ticketFragment;
        }
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}