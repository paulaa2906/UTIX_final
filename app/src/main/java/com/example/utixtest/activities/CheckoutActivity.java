package com.example.utixtest.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.utixtest.R;
import com.example.utixtest.adapter.RVTicketAdapter;
import com.example.utixtest.models.TicketsModel;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    private ArrayList<TicketsModel> tickets = new ArrayList<TicketsModel>();

    private RVTicketAdapter ticketsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

    }

    public void doAddTicket(View view) {
        tickets.add(new TicketsModel("The Boy and The Heron", "Fri, 5 Jan 2024 | 20.10", "C3, C4, C5"));
        ticketsAdapter.notifyDataSetChanged();
    }
}