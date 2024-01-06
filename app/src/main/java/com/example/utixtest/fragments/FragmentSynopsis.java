package com.example.utixtest.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.utixtest.R;
import com.example.utixtest.models.MovieModel;

public class FragmentSynopsis extends Fragment {

    private TextView synopsis;

    private String overview_container;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_synopsis, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle argument = getArguments();
        Log.d("Qiqi", "onViewCreated: " + argument.getString("overview"));

        overview_container = argument.getString("overview");

        synopsis = requireView().findViewById(R.id.txt_detail_synopsis);
        synopsis.setText(overview_container);

    }
}
