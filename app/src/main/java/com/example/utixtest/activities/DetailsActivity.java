package com.example.utixtest.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.utixtest.R;
import com.example.utixtest.fragments.FragmentHome;
import com.example.utixtest.models.MovieModel;

public class DetailsActivity extends AppCompatActivity {

    private TextView movie_title;
    private TextView movie_release_date;

    private TextView movie_overview;

    private RatingBar movie_vote;

    private ImageView movie_backdrop;

    private MovieModel movie_object;

    private ImageButton back_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        //back button
        back_button = findViewById(R.id.back_arrow_detail);

        //movie stuff
        movie_backdrop = findViewById(R.id.img_detail_movie_backdrop);
        movie_title = findViewById(R.id.txt_detail_movie_title);
        movie_release_date = findViewById(R.id.txt_detail_movie_release);
        movie_overview = findViewById(R.id.txt_detail_synopsis);
        movie_vote = (RatingBar) findViewById(R.id.rating_detail_movie_popularity);

        Intent intent = getIntent();
        movie_object = (MovieModel) intent.getSerializableExtra("movie_object");

        Log.d("Zhongli", "Movie ID from intent: " + movie_object.getMovie_id());

        movie_title.setText(movie_object.getTitle());
        //picasso didn't work, so i use glide instead
//                    Picasso.Builder builder = new Picasso.Builder(context);
//                    builder.downloader(new OkHttp3Downloader(context));
//                    builder.build().load("https://image.tmdb.org/t/p/w500" + movie_object.getPoster_path())
//                            .placeholder(R.drawable.ic_launcher_background)
//                            .error(R.drawable.ic_launcher_foreground)
//                            .into(movie_poster);
        Glide.with(this).
                load("https://image.tmdb.org/t/p/w780"+ movie_object.getBackdrop_path()).into(movie_backdrop);
        movie_release_date.setText(movie_object.getRelease_date());
        movie_overview.setText(movie_object.getMovie_overview());
        movie_vote.setRating(movie_object.getVote_average()/2);

        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailsActivity.this, FragmentHome.class));
            }
        });
    }

}
