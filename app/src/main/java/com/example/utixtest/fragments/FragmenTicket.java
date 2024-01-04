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
import com.example.utixtest.adapter.RVTicketAdapter;
import com.example.utixtest.models.TicketsModel;

import java.util.ArrayList;

public class FragmenTicket extends Fragment {

    private ArrayList<TicketsModel> tickets = new ArrayList<TicketsModel>();

    private RVTicketAdapter ticketsAdapter;

    RecyclerView rv_tickets;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ticket, null);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tickets.add(new TicketsModel("Wonka", "Sat, 6 Jan 2024 | 16.30", "A4, A5"));

        rv_tickets = view.findViewById(R.id.ticketsListRecyclerView);
        rv_tickets.setHasFixedSize(true);
        ticketsAdapter = new RVTicketAdapter(tickets);
        rv_tickets.setAdapter(ticketsAdapter);
        rv_tickets.setLayoutManager(new LinearLayoutManager(getActivity()));

    }

}
