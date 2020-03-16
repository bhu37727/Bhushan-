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
import com.android.veggitech.growapp.activity.GrowModeTutorialActivity;
import com.android.veggitech.growapp.activity.GrowSpaceTutorialActivity;
import com.android.veggitech.growapp.model.TutorialModel;

import java.util.ArrayList;

public class TutorialAdapter  extends RecyclerView.Adapter<TutorialAdapter.vieHolder> {

    Context context;
    ArrayList<TutorialModel> arrayList = new ArrayList<TutorialModel>();
    Intent intent;

    public TutorialAdapter(Context context, ArrayList<TutorialModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public vieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tutorial_item, parent, false);
        return new TutorialAdapter.vieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull vieHolder holder, final int position) {

        holder.name.setText(arrayList.get(position).getTitle());
        holder.description.setText(arrayList.get(position).getDescription());
        holder.tutorialImage.setImageResource(arrayList.get(position).getImage());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(context,GrowSpaceTutorialActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        //intent = new Intent(context, MainActivity.class);
                        //context.startActivity(intent);
                       // Toast.makeText(context, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 1:
                        intent = new Intent(context, GrowModeTutorialActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        break;
                    case 2:
                        Toast.makeText(context, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        Toast.makeText(context, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 4:
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

    public class vieHolder extends RecyclerView.ViewHolder {

        ImageView tutorialImage;
        TextView name, description;
        CardView cardView;

        public vieHolder(@NonNull View itemView) {
            super(itemView);
            tutorialImage = itemView.findViewById(R.id.imageViewTutorial);
            name = itemView.findViewById(R.id.textViewTutorial);
            description = itemView.findViewById(R.id.textViewTutorialDes);
            cardView = itemView.findViewById(R.id.cardViewTutorial);
        }
    }
}

