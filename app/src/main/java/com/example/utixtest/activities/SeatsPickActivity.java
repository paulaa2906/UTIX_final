package com.example.utixtest.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.utixtest.R;
import com.example.utixtest.models.ScheduleModel;

import java.util.ArrayList;
import java.util.List;

public class SeatsPickActivity extends AppCompatActivity implements View.OnClickListener{
    ViewGroup layout_seats;

    String seats = "_AUUUAAAAAAAAAAA_/"
            + "_________________/"
            + "AA__AAAARRRRR__RR/"
            + "AU__UUUAAAAAA__AA/"
            + "AA__AAAAAAAAA__AA/"
            + "AA__AARUUAARR__AA/"
            + "UA__AAAA_RRRR__AA/"
            + "AA__AAAA_RRAA__UU/"
            + "RA__AARR_UUAA__AA/"
            + "AA__UUAA_UURR__RR/"
            + "_________________/"
            + "UA_AAAAAAAAAAA_AR/"
            + "AR_AAAAAAAAAAA_AA/"
            + "AA_AAAAAAAUUUU_AA/"
            + "AA_AAAAAAUAAAA_AA/"
            + "_________________/";

    private List<TextView> seatsList = new ArrayList<>();
    private int seatSize = 100, seatGap = 10;
    private int AVAILABLE = 1, BOOKED = 2, RESERVED = 3;
    private String selected = "";

    private TextView picked_seat;
    private TextView total_price;

    private TextView playing_time;

    private TextView seat_qty;

    private TextView mobie_title;

    private TextView seat_price;

    private ImageButton btn_back;

    private Button btn_confirm;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_seats);
        layout_seats = findViewById(R.id.scrl_seats);
        picked_seat = findViewById(R.id.txt_seats_num);
        total_price = findViewById(R.id.txt_seat_total_price);
        seat_price = findViewById(R.id.txt_seat_price);
        playing_time = findViewById(R.id.txt_seat_time);
        seat_qty = findViewById(R.id.txt_seat_qty);
        btn_back = findViewById(R.id.btn_back_seats_picker);
        btn_confirm = findViewById(R.id.btn_seat_confirm);

        Intent intent = getIntent();
        String txt_playing_time = intent.getStringExtra("selectedTime");
        String txt_seat_price = intent.getStringExtra("price");
        playing_time.setText(txt_playing_time);
        seat_price.setText(txt_seat_price);


        Log.d("Qiqi", "price: "+ txt_seat_price);

        seats = "/" + seats;

        LinearLayout seatLayout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        seatLayout.setOrientation(LinearLayout.VERTICAL);
        seatLayout.setLayoutParams(params);
        seatLayout.setPadding(seatGap*8, seatGap*8, seatGap*8, seatGap*8);
        layout_seats.addView(seatLayout);

        LinearLayout layout = null;

        int count = 0;

        for(int i = 0; i < seats.length(); i++){
            if(seats.charAt(i) == '/'){
                layout = new LinearLayout(this);
                layout.setOrientation(LinearLayout.HORIZONTAL);
                seatLayout.addView(layout);
            } else if (seats.charAt(i) == 'U') {
                count++;
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGap, seatGap, seatGap, seatGap);
                textView.setLayoutParams(layoutParams);
                textView.setPadding(0,0,0,seatGap*2);
                textView.setId(count);
                textView.setGravity(Gravity.CENTER);
                textView.setBackgroundResource(R.drawable.seat_booked);
                textView.setTextColor(Color.WHITE);
                textView.setTag(BOOKED);
                textView.setText(count+"");
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                layout.addView(textView);
                seatsList.add(textView);
                textView.setOnClickListener(this);
            }else if (seats.charAt(i) == 'A') {
                count++;
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGap, seatGap, seatGap, seatGap);
                textView.setLayoutParams(layoutParams);
                textView.setPadding(0,0,0,seatGap*2);
                textView.setId(count);
                textView.setGravity(Gravity.CENTER);
                textView.setBackgroundResource(R.drawable.seat_available);
                textView.setTextColor(Color.BLACK);
                textView.setTag(AVAILABLE);
                textView.setText(count+"");
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                layout.addView(textView);
                seatsList.add(textView);
                textView.setOnClickListener(this);
            }else if (seats.charAt(i) == 'R') {
                count++;
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGap, seatGap, seatGap, seatGap);
                textView.setLayoutParams(layoutParams);
                textView.setPadding(0,0,0,seatGap*2);
                textView.setId(count);
                textView.setGravity(Gravity.CENTER);
                textView.setBackgroundResource(R.drawable.seat_reserved);
                textView.setTextColor(Color.WHITE);
                textView.setTag(RESERVED);
                textView.setText(count+"");
                textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 9);
                layout.addView(textView);
                seatsList.add(textView);
                textView.setOnClickListener(this);
            }else if (seats.charAt(i) == '_') {
                TextView textView = new TextView(this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(seatSize, seatSize);
                layoutParams.setMargins(seatGap, seatGap, seatGap, seatGap);
                textView.setLayoutParams(layoutParams);
                textView.setTextColor(Color.TRANSPARENT);
                textView.setText("");
                layout.addView(textView);
            }
        }

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeatsPickActivity.this, DetailsActivity.class));
            }
        });

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SeatsPickActivity.this, CheckoutActivity.class));
            }
        });

    }

    @Override
    public void onClick(View v) {
        if((int) v.getTag() == AVAILABLE){
            if(selected.contains(v.getId()+ ",")){
                selected = selected.replace(+v.getId()+ ",", "");
                v.setBackgroundResource(R.drawable.seat_available);
            }else{
                selected = selected + v.getId() + ",";
                v.setBackgroundResource(R.drawable.seat_selected);
            }
            updateSelectedSeatsTextView();
        } else if ((int) v.getTag() == BOOKED) {
            Toast.makeText(this, "This Seat is booked!", Toast.LENGTH_SHORT ).show();
        }else if ((int) v.getTag() == RESERVED) {
            Toast.makeText(this, "This Seat is reserved!", Toast.LENGTH_SHORT ).show();
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void updateSelectedSeatsTextView() {
        String[] selectedSeatNum = selected.split(",");
        StringBuilder selectedSeats = new StringBuilder();
        String txt_price = seat_price.getText().toString();
        Log.d("Qiqi", "updateSelectedSeatsTextView: " + txt_price);
        Integer price = Integer.valueOf(txt_price);
        Integer count = 0;
        Integer total = 0;
        for (String seatId : selectedSeatNum) {
            if (!seatId.isEmpty()) {
                selectedSeats.append(seatId).append(", ");
                count++;
            }
        }

        total = price*count;

        // Update the TextView
        if (selectedSeats.length() > 0) {
            selectedSeats.setLength(selectedSeats.length() - 2); // Remove the trailing comma and space
        }
        picked_seat.setText("Seats: " + selectedSeats.toString());
        seat_qty.setText("Quantity: " + String.valueOf(count));
        total_price.setText("Total:  Rp." + String.valueOf(total));

    }
}
