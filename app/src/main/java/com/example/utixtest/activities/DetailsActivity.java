package com.example.utixtest.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.utixtest.R;
import com.example.utixtest.models.MovieModel;
import com.example.utixtest.request.GetServices;
import com.example.utixtest.utils.Credentials;
import com.example.utixtest.utils.MovieAPI;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsActivity extends AppCompatActivity {

    private ImageView movie_poster;
    private TextView movie_title;
    private TextView movie_release_date;

    private TextView movie_overview;

    private RatingBar movie_vote;

    private Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        Intent intent = getIntent();
        MovieModel movie_id = (MovieModel) intent.getSerializableExtra("id");

        Log.d("Zhongli", "id: " + movie_id.getMovie_id());

        movie_poster = findViewById(R.id.img_detail_movie_poster);
        movie_title = findViewById(R.id.txt_detail_movie_title);
        movie_release_date = findViewById(R.id.txt_detail_movie_release);
        movie_overview = findViewById(R.id.txt_detail_synopsis);
        movie_vote = (RatingBar) findViewById(R.id.rating_detail_movie_popularity);
        MovieAPI movieAPI = GetServices.getMovieAPI();

        Call<MovieModel> responseCall = movieAPI.getMovie(
                movie_id.getMovie_id(),
                Credentials.API_KEY
        );

        responseCall.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if (response.isSuccessful()){
                    Log.d("Zhongli", "Response: " + response.body().toString());
                    MovieModel movie = response.body();

                    Log.d("Zhongli", "Movie Title: " + movie.getTitle());

                    movie_title.setText(movie.getTitle());
//                    Picasso.Builder builder = new Picasso.Builder(context);
//                    builder.downloader(new OkHttp3Downloader(context));
//                    builder.build().load("https://image.tmdb.org/t/p/w500" + movie.getPoster_path())
//                            .placeholder(R.drawable.ic_launcher_background)
//                            .error(R.drawable.ic_launcher_foreground)
//                            .into(movie_poster);
                    movie_release_date.setText(movie.getRelease_date());
                    movie_overview.setText(movie.getMovie_overview());
                    movie_vote.setRating(movie.getVote_average()/2);

                }
                else {
                    try {
                        Log.d("Zhongli", "error: " + response.errorBody().string());
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
