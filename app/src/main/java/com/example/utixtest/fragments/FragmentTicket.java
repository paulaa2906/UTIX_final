package com.example.utixtest.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utixtest.R;
import com.example.utixtest.adapter.RVTicketAdapter;
import com.example.utixtest.helper.MovieDataPasser;
import com.example.utixtest.helper.SeatsDataPasser;
import com.example.utixtest.helper.UserIdDataPasser;
import com.example.utixtest.models.TicketsModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class FragmentTicket extends Fragment {

    private ArrayList<TicketsModel> tickets = new ArrayList<TicketsModel>();

    private TicketsModel ticketsModel;

    private RVTicketAdapter ticketsAdapter;

    RecyclerView rv_tickets;

    private String userId;
    private DatabaseReference orderRef;
    private String movie_title;
    private String movie_date;
    private String movie_time;
    private String movie_seats;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ticket, null);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userId = UserIdDataPasser.getInstance().getUser_id();
        orderRef = FirebaseDatabase.getInstance("https://utix-test-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("users").child(userId).child("ticket");
        rv_tickets = view.findViewById(R.id.ticketsListRecyclerView);
        rv_tickets.setHasFixedSize(true);
        ticketsAdapter = new RVTicketAdapter(tickets);
        rv_tickets.setAdapter(ticketsAdapter);
        rv_tickets.setLayoutManager(new LinearLayoutManager(getActivity()));

        movie_title = MovieDataPasser.getInstance().getMovieTitle();
        movie_date = SeatsDataPasser.getInstance().getSeats_date();
        movie_time = SeatsDataPasser.getInstance().getSeats_time();
        movie_seats = SeatsDataPasser.getInstance().getSeats_num();
        tickets.add(new TicketsModel(movie_title, movie_date, movie_time, movie_seats));

        ticketsAdapter.notifyDataSetChanged();
    }

}
