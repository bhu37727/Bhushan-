package com.android.veggitech.growapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.model.FvtPlantModel;

import java.util.ArrayList;

public class FvtPlantAdapter extends BaseAdapter {

    Context context;
    private final String [] plantName;
    private final String [] numberOfPlants;
    private final String [] plantDays;
    private final int [] images;
    LayoutInflater layoutInflater;
    ArrayList<FvtPlantModel> arrayList = new ArrayList<FvtPlantModel>();
    FvtPlantModel fvtPlantModel = new FvtPlantModel();
    int image;
    String pName, Pdays, pNumber;

    public FvtPlantAdapter(Context context, String[] plantName, String[] numberOfPlants, String[] plantDays, int[] images) {
        this.context = context;
        this.plantName = plantName;
        this.numberOfPlants = numberOfPlants;
        this.plantDays = plantDays;
        this.images = images;
    }

    @Override
    public int getCount() {
        return plantName.length;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View view = layoutInflater.inflate(R.layout.fvt_plant_list_item, parent, false);

        ImageView plant = (ImageView) view.findViewById(R.id.imageViewPlant);
        image = fvtPlantModel.getImage();
        plant.setImageResource(images[position]);
        TextView name = (TextView) view.findViewById(R.id.textViewPlantName);
        name.setText(plantName[position]);
        TextView days = (TextView) view.findViewById(R.id.textViewDays);
        days.setText(plantDays[position]);
        TextView number = (TextView) view.findViewById(R.id.textViewPlantNumber);
        number.setText(numberOfPlants[position]);
        return view;
    }
}
