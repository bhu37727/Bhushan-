package com.android.veggitech.growapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.activity.GrowSpaceTutorialActivity;
import com.android.veggitech.growapp.model.GrowthStageModel;
import com.android.veggitech.growapp.model.TutorialModel;

import java.util.ArrayList;

public class GrowthStageAdapter extends RecyclerView.Adapter<GrowthStageAdapter.viewHolder> {

    Context context;
    ArrayList<GrowthStageModel> arrayList = new ArrayList<GrowthStageModel>();
    Intent intent;

    public GrowthStageAdapter(Context context, ArrayList<GrowthStageModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_plant_growth_item, parent, false);
        return new GrowthStageAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {

        holder.stageName.setText(arrayList.get(position).getStageName());
        holder.stageDes.setText(arrayList.get(position).getStageDes());
        holder.image1.setImageResource(arrayList.get(position).getImage1());
        holder.image2.setImageResource(arrayList.get(position).getImage2());
        holder.image3.setImageResource(arrayList.get(position).getImage3());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(context, GrowSpaceTutorialActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        //intent = new Intent(context, MainActivity.class);
                        //context.startActivity(intent);
                        // Toast.makeText(context, "Launch Soon", Toast.LENGTH_LONG).show();
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

        ImageView image1, image2, image3;
        TextView stageName, stageDes;
        CardView cardView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.imageViewStage1);
            image2 = itemView.findViewById(R.id.imageViewStage2);
            image3 = itemView.findViewById(R.id.imageViewStage3);
            stageName = itemView.findViewById(R.id.textViewPlantGrowth);
            stageDes = itemView.findViewById(R.id.textViewPlantGrowthDes);
            cardView = itemView.findViewById(R.id.cardViewPlantGrowth);
        }
    }
}
