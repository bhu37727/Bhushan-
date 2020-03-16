package com.android.veggitech.growapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.model.MonitorModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlantGrowthMonitorAdapter extends RecyclerView.Adapter<PlantGrowthMonitorAdapter.viewHolder>  {

    Context context;
    ArrayList<MonitorModel>list = new ArrayList<MonitorModel>();

    public PlantGrowthMonitorAdapter(Context context, ArrayList<MonitorModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext ()).inflate(R.layout.plant_monitor_item, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        holder.t1.setText(list.get(position).getTitle1());
        holder.t2.setText(list.get(position).getTitle2());
        holder.img1.setImageResource(list.get(position).getImg1());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView t1, t2;
        CardView cardView4;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            img1 = itemView.findViewById ( R.id.imageView3 ) ;
            t1 = itemView.findViewById( R.id.textView9);
            t2 = itemView.findViewById ( R.id.textView10 );
            cardView4 = itemView.findViewById ( R.id.cardViewPlantMonitor);
        }
    }
}
