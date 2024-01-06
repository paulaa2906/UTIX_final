package com.example.utixtest.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utixtest.R;
import com.example.utixtest.adapter.RVScheduleAdapter;
import com.example.utixtest.models.ScheduleModel;

import java.util.ArrayList;
import java.util.List;

public class FragmentSchedule extends Fragment {

    private RecyclerView rvSchedules;

    List<ScheduleModel> schedules = new ArrayList<>();
    private RVScheduleAdapter rvScheduleAdapter;

    private ArrayList<String> timelist1;
    private ArrayList<String> timelist2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        timelist1 = new ArrayList<>();
        timelist1.add("13.00");
        timelist1.add("14.30");
        timelist1.add("16.00");
        timelist1.add("17.30");
        timelist1.add("19.00");

        timelist2 = new ArrayList<>();
        timelist2.add("10.00");
        timelist2.add("11.45");
        timelist2.add("14.00");
        timelist2.add("16.00");
        timelist2.add("18.30");

        schedules.add(new ScheduleModel("SPARK Mall", "Regular 2D", 50000, timelist1));
        schedules.add(new ScheduleModel("Grand Mall", "Deluxe", 150000, timelist2));

        rvSchedules = requireView().findViewById(R.id.rv_schedule);
        rvSchedules.setHasFixedSize(true);
        rvScheduleAdapter = new RVScheduleAdapter(schedules, getActivity());
        rvSchedules.setAdapter(rvScheduleAdapter);
        rvSchedules.setLayoutManager(new LinearLayoutManager(getActivity()));

    }
}
