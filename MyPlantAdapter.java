package com.android.veggitech.growapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.veggitech.growapp.R;

public class MyPlantAdapter extends BaseAdapter {

    Context context;
    private final String plantName;
    private final String plantDays;
    private final String startDate;
    private final String endDate;
    private final int [] images;
    LayoutInflater layoutInflater;
    View view;
    ImageView imageView;
    TextView pName, pDays;
    ProgressBar progressBar;
    int num = 70;

    public MyPlantAdapter(Context context, String plantName, String plantDays, String startDate, String endDate, int[] images) {
        this.context = context;
        this.plantName = plantName;
        this.plantDays = plantDays;
        this.startDate = startDate;
        this.endDate = endDate;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
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
        view = layoutInflater.inflate(R.layout.my_plant_item_list, parent, false);
        imageView = view.findViewById(R.id.imageViewMyPlant);
        imageView.setImageResource(images[position]);
        pName = view.findViewById(R.id.textViewMyPlantName);
        pName.setText(plantName);
        pDays = view.findViewById(R.id.textViewMyPlantDays);
        pDays.setText(plantDays +" Days Left");
        progressBar = view.findViewById(R.id.myPlantProgress);
        progressBar.setMax(num);
        //progressBar.getIndeterminateDrawable().setColorFilter(Color.parseColor("#88d840"),
              //  android.graphics.PorterDuff.Mode.MULTIPLY);
        return view;
    }
}
