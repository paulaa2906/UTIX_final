package com.example.utixtest.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.utixtest.R;
import com.example.utixtest.adapter.RVTicketAdapter;
import com.example.utixtest.fragments.FragmentHome;
import com.example.utixtest.fragments.FragmentTicket;
import com.example.utixtest.helper.MovieDataPasser;
import com.example.utixtest.helper.SeatsDataPasser;
import com.example.utixtest.helper.UserIdDataPasser;
import com.example.utixtest.models.TicketsModel;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {

    FirebaseDatabase orderedTicket;
    private TicketsModel tickets;
    private RVTicketAdapter ticketsAdapter;
    private String movie_title;
    private String movie_date;
    private String movie_time;
    private String movie_seats;
    private String movie_poster;
    private String ticket_price;
    private String total_price;
    private Float admin_fee;

    private ImageButton btn_back;
    private Button btn_confirm;
    private Button btn_cancel;

    //container
    private ImageView poster;
    private TextView title, date, time, seats, price, txt_admin_fee, total_payment;

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        movie_title = MovieDataPasser.getInstance().getMovieTitle();
        movie_date = SeatsDataPasser.getInstance().getSeats_date();
        movie_time = SeatsDataPasser.getInstance().getSeats_time();
        movie_poster = MovieDataPasser.getInstance().getPoster_path();
        movie_seats = SeatsDataPasser.getInstance().getSeats_num();
        ticket_price = SeatsDataPasser.getInstance().getSeats_price();
        total_price = SeatsDataPasser.getInstance().getSeats_total_price();

        Log.d("Klee", "Data: " + movie_title +
                ", " + movie_date +
                ", " + movie_time +
                ", " + movie_seats +
                ", " + movie_poster +
                ", " + ticket_price +
                ", " + total_price);

        //calculate admin fee
        admin_fee = Float.valueOf(total_price) * 2/100;
        Log.d("Klee", "admin fee:" + admin_fee);

        Float subtotal = Float.valueOf(total_price) + admin_fee;

        //set up container
        title = findViewById(R.id.txt_movie_title_order);
        date = findViewById(R.id.txt_order_date);
        time = findViewById(R.id.txt_order_time);
        seats = findViewById(R.id.txt_order_seats);
        price = findViewById(R.id.txt_order_price);
        txt_admin_fee = findViewById(R.id.txt_order_adminFee);
        total_payment = findViewById(R.id.txt_order_totalPay);
        poster = findViewById(R.id.img_movie_poster_order);
        btn_back = findViewById(R.id.back_arrow_order);
        btn_cancel = findViewById(R.id.btn_cancel_order);
        btn_confirm = findViewById(R.id.btn_confirm_order);

        Glide.with(this).
                load("https://image.tmdb.org/t/p/w500"+ movie_poster).into(poster);

        title.setText(movie_title);
        date.setText(movie_date);
        time.setText(movie_time);
        seats.setText(movie_seats);
        price.setText(ticket_price);
        txt_admin_fee.setText(String.valueOf(admin_fee));
        total_payment.setText(String.valueOf(subtotal));



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CheckoutActivity.this, SeatsPickActivity.class));
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CheckoutActivity.this, "Order Canceled", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CheckoutActivity.this, SeatsPickActivity.class));
            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAddTicket();
                Toast.makeText(CheckoutActivity.this, "Order Confirmed Succesfully!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CheckoutActivity.this, HomeActivity.class));
                MovieDataPasser.getInstance().setMovieTitle(title.getText().toString());
                SeatsDataPasser.getInstance().setSeats_date(date.getText().toString());
                SeatsDataPasser.getInstance().setSeats_time(time.getText().toString());
                SeatsDataPasser.getInstance().setSeats_num(seats.getText().toString());
            }
        });
    }

    public void doAddTicket() {
        orderedTicket = FirebaseDatabase.getInstance("https://utix-test-default-rtdb.asia-southeast1.firebasedatabase.app");
        DatabaseReference orderRef = orderedTicket.getReference("users");
        String orderTicketKey = orderRef.push().getKey();
        userId = UserIdDataPasser.getInstance().getUser_id();
        tickets = new TicketsModel(
                title.getText().toString(),
                date.getText().toString(),
                time.getText().toString(),
                seats.getText().toString()
        );

        orderRef.child(userId).child("ticket").child(orderTicketKey).setValue(tickets);
        UserIdDataPasser.getInstance().setUser_id(userId);
        Toast.makeText(this, "Data succesfully added", Toast.LENGTH_SHORT).show();
    }
}