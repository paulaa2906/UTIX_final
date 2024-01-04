package com.example.utixtest.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utixtest.R;
import com.example.utixtest.activities.DetailsActivity;
import com.example.utixtest.models.MovieModel;
import com.squareup.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RVHomeAdapter extends RecyclerView.Adapter<RVHomeAdapter.CustomViewHolder> {

    private List<MovieModel> nowPlayingMovies;
    private Context context;




    public RVHomeAdapter(List<MovieModel> nowPlayingMovies, Context context) {
        this.nowPlayingMovies = nowPlayingMovies;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_home, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.movie_titles.setText(nowPlayingMovies.get(position).getTitle());

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load("https://image.tmdb.org/t/p/w500" + nowPlayingMovies.get(position).getPoster_path())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(holder.movie_posters);

        Picasso.get().setLoggingEnabled(true);

    }

    @Override
    public int getItemCount() {
        return nowPlayingMovies.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

      private ImageView movie_posters;
      private TextView movie_titles;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            movie_posters = itemView.findViewById(R.id.img_movie_poster);
            movie_titles = itemView.findViewById(R.id.txt_movie_title);
        }


        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("id", nowPlayingMovies.get(position).getMovie_id());
            context.startActivity(intent);

        }
    }

}
