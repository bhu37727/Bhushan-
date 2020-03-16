package com.android.veggitech.growapp.adapter;

import android.content.Context;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.android.veggitech.growapp.activity.BrinjalPlantDetailsActivity;
import com.android.veggitech.growapp.activity.CucumberPlantDetailsActivity;
import com.android.veggitech.growapp.model.ItemModel;
import com.android.veggitech.growapp.R;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.viewHolder> {

    Context context;
    ArrayList<ItemModel> arrayList;

    public CustomAdapter(Context context, ArrayList<ItemModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public  CustomAdapter.viewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false);
        return new viewHolder(view);
    }
    @Override
    public  void onBindViewHolder(CustomAdapter.viewHolder viewHolder, final int position) {
        viewHolder.iconName.setText(arrayList.get(position).getName());
        viewHolder.icon.setImageResource(arrayList.get(position).getImage());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position){
                    case 0:
                        Toast.makeText(context, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        Toast.makeText(context, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        intent = new Intent(context, BrinjalPlantDetailsActivity.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context, CucumberPlantDetailsActivity.class);
                        context.startActivity(intent);
                        break;
                    case 4:
                        Toast.makeText(context, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 5:
                        Toast.makeText(context, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 6:
                        Toast.makeText(context, "Launch Soon", Toast.LENGTH_LONG).show();
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
        TextView iconName;
        CardView cardView;

        public viewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            iconName = (TextView) itemView.findViewById(R.id.icon_name);
            cardView =(CardView) itemView.findViewById(R.id.cardViewPlant);
        }
    }

}
