package com.example.utixtest.viewModel;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.utixtest.R;

public class MovieDetails extends AppCompatActivity {
    private ImageView movie_poster;
    private TextView movie_title;
    private TextView movie_release_date;
    private TextView movie_synopsis;

    private Context context;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_movie_detail);

    }
}
