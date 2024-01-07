package com.example.utixtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utixtest.R;
import com.example.utixtest.models.TicketsModel;

import java.util.ArrayList;

public class RVTicketAdapter extends RecyclerView.Adapter<RVTicketAdapter.CustomViewHolder> {

    private ArrayList<TicketsModel> tickets;

    public RVTicketAdapter(ArrayList<TicketsModel> tickets) {
        this.tickets = tickets;
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(R.layout.rv_tickets, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        TicketsModel ticket = tickets.get(position);

        TextView txtTitle = holder.txtTitle;
        TextView txtTime = holder.txtTime;
        TextView txtDate = holder.txtDate;
        TextView txtSeat = holder.txtSeat;

        txtTitle.setText(ticket.getTitle());
        txtTime.setText(ticket.getTime());
        txtDate.setText(ticket.getDate());
        txtSeat.setText(ticket.getSeats());
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView txtTitle;
        public TextView txtTime;
        public TextView txtDate;
        public TextView txtSeat;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            txtTitle = itemView.findViewById(R.id.txt_title);
            txtTime = itemView.findViewById(R.id.txt_time);
            txtDate = itemView.findViewById(R.id.txt_date);
            txtSeat = itemView.findViewById(R.id.txt_seat);
        }

        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            notifyDataSetChanged();
        }
    }
}

