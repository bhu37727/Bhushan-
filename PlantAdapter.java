package com.android.veggitech.growapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.model.FvtPlantModel;
import com.android.veggitech.growapp.model.PlantItemModel;
import com.android.veggitech.growapp.model.TutorialModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlantAdapter extends BaseAdapter {

    int[] images;
    String[] plantName;
    String[] numberOfPlants;
    String[] plantDays;
    Context context;
    String image;
    private ArrayList<PlantItemModel> dataModelArrayList = new ArrayList<PlantItemModel>();
    LayoutInflater layoutInflater;
    ArrayList<FvtPlantModel> arrayList = new ArrayList<FvtPlantModel>();

    public PlantAdapter(Context context, ArrayList<PlantItemModel> dataModelArrayList){
        //super(context, R.layout.single_list_app_item, utilsArrayList);
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.dataModelArrayList = dataModelArrayList;
    }

    @Override
    public int getCount() {
        return dataModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup container) {
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.plant_item, container,
                false);
        ImageView plant = (ImageView) view.findViewById(R.id.imageViewPlant);
        image = dataModelArrayList.get(position).getImageUrl().toString();
        Picasso.get().load(image).into(plant);
        //plant.setImageResource(images[position]);

        TextView name = (TextView) view.findViewById(R.id.textViewPlantName);
        name.setText(dataModelArrayList.get(position).getPlantName().toString());
        TextView days = (TextView) view.findViewById(R.id.textViewDays);
        days.setText(dataModelArrayList.get(position).getHarvestPeriod().toString()+" Days");
        TextView number = (TextView) view.findViewById(R.id.textViewPlantNumber);
        number.setText(dataModelArrayList.get(position).getPlantSqm().toString()+" Per Sqm");

        final ToggleButton toggleButton = (ToggleButton) view.findViewById(R.id.toggleButtonFavourite);
        toggleButton.setChecked(false);
        toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(view.getContext(), R.drawable.fvtgray));
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(view.getContext(), R.drawable.fvtred));
                    int image = images[position];
                    String pName = plantName[position];
                    String pDays = plantDays[position];
                    String pNumber = numberOfPlants[position];

                    FvtPlantModel plantModel = new FvtPlantModel();
                    plantModel.setImage(image);
                    plantModel.setPlantName(pName);
                    plantModel.setPlantDays(pDays);
                    plantModel.setPlantNumber(pNumber);
                    arrayList.add(plantModel);
                    //Toast.makeText(context, "Item is" +pName, Toast.LENGTH_LONG).show();
                }
                else
                    toggleButton.setBackgroundDrawable(ContextCompat.getDrawable(view.getContext(), R.drawable.fvtgray));
            }
        });

       // ((ViewPager) container).addView(itemView, 0);
        return view;
    }
}
