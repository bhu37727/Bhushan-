package com.android.veggitech.growapp.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.model.PlantModel;

public class CustomCucumberPlantAdapter extends RecyclerView.Adapter<CustomCucumberPlantAdapter.viewHolder> {

    Context context;
    ArrayList<PlantModel> arrayList;

    public CustomCucumberPlantAdapter(Context context, ArrayList<PlantModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public  CustomCucumberPlantAdapter.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cucumber_plant_item_list, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        holder.iconTitle.setText(arrayList.get(position).getTitle());
        holder.iconData.setText(arrayList.get(position).getData());
        holder.icon.setImageResource(arrayList.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position){
                    case 0:
                        Toast.makeText(context, "Sow Depth", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(context, "Distance B/n Plants", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        Toast.makeText(context, "Grow Mode", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(context, "Plants Per Sqm", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
                        Toast.makeText(context, "Germination Period", Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Toast.makeText(context, "Transplanting Time", Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Toast.makeText(context, "Planting Location", Toast.LENGTH_LONG).show();
                        break;
                    case 7:
                        Toast.makeText(context, "Plant Height", Toast.LENGTH_LONG).show();
                        break;
                    case 8:
                        Toast.makeText(context, "Harvest Period", Toast.LENGTH_LONG).show();
                        break;
                    case 9:
                        Toast.makeText(context, "Minimum Temperature", Toast.LENGTH_LONG).show();
                        break;
                    case 10:
                        Toast.makeText(context, "Minimum pH", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        TextView iconTitle;
        TextView iconData;
        CardView cardView;

        public viewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.plant);
            iconData = (TextView) itemView.findViewById(R.id.titleData);
            cardView = (CardView) itemView.findViewById(R.id.cardViewPlant);
            iconTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
        }
    }

}
