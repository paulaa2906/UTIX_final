package com.example.utixtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.utixtest.R;
import com.example.utixtest.models.ScheduleModel;

import java.util.List;

public class RVScheduleAdapter extends RecyclerView.Adapter<RVScheduleAdapter.CustomViewHolder> {

    private List<ScheduleModel> schedules;
    private Context context;

    public RVScheduleAdapter(List<ScheduleModel> schedules, Context context) {
        this.schedules = schedules;
        this.context = context;
    }

    @NonNull
    @Override
    public RVScheduleAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rv_schedule, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVScheduleAdapter.CustomViewHolder holder, int position) {
        holder.mallName.setText(schedules.get(position).getMallName());
        holder.cinemaType.setText(schedules.get(position).getCinemaType());
        holder.price.setText(String.valueOf(schedules.get(position).getPrice()));
        for (int i = 0; i < schedules.get(position).getTimeList().size(); i++){

            String cursor = schedules.get(position).getTimeList().get(i);

            TextView currentText;

            switch (i){
                case 0:
                    currentText = holder.time1;
                    break;
                case 1:
                    currentText = holder.time2;
                    break;
                case 2:
                    currentText = holder.time3;
                    break;
                case 3:
                    currentText = holder.time4;
                    break;
                case 4:
                    currentText = holder.time5;
                    break;

                default:
                    return;
            }

            currentText.setText(cursor);

        }
    }

    @Override
    public int getItemCount() {
        return schedules.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView mallName;
        private TextView cinemaType;
        private TextView price;

        private TextView time1, time2, time3, time4, time5;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mallName = itemView.findViewById(R.id.txt_mall_name);
            cinemaType = itemView.findViewById(R.id.txt_cinema_type);
            price = itemView.findViewById(R.id.txt_movie_price);
            time1 = itemView.findViewById(R.id.txt_time1);
            time2 = itemView.findViewById(R.id.txt_time2);
            time3 = itemView.findViewById(R.id.txt_time3);
            time4 = itemView.findViewById(R.id.txt_time4);
            time5 = itemView.findViewById(R.id.txt_time5);
        }
    }
}
