package com.android.veggitech.growapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.activity.DutchBucketActivity;
import com.android.veggitech.growapp.activity.FoamBucketActivity;
import com.android.veggitech.growapp.activity.GrowSpaceTutorialActivity;
import com.android.veggitech.growapp.activity.IVFActivity;
import com.android.veggitech.growapp.activity.MainActivity;
import com.android.veggitech.growapp.activity.MyGrowSpaceActivity;
import com.android.veggitech.growapp.activity.PlantActivity;
import com.android.veggitech.growapp.model.GrowModel;
import com.android.veggitech.growapp.model.TutorialModel;

import java.util.ArrayList;

public class GrowModeAdapter extends RecyclerView.Adapter<GrowModeAdapter.vieHolder> {

    Context context;
    ArrayList<GrowModel> arrayList = new ArrayList<GrowModel>();
    Intent intent;

    public GrowModeAdapter(Context context, ArrayList<GrowModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public GrowModeAdapter.vieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grow_mode_item, parent, false);
        return new GrowModeAdapter.vieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrowModeAdapter.vieHolder holder, final int position) {

        holder.name.setText(arrayList.get(position).getMode());
        holder.number.setText(arrayList.get(position).getNumberPerSqm());
        holder.imageView.setImageResource(arrayList.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(context, DutchBucketActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(context, FoamBucketActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(context, IVFActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(context, MyGrowSpaceActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class vieHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, number;
        CardView cardView;

        public vieHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewGrow);
            name = itemView.findViewById(R.id.textViewGrowName);
            number = itemView.findViewById(R.id.textViewGrowNumber);
            cardView = itemView.findViewById(R.id.cardViewGrow);
        }
    }
}
