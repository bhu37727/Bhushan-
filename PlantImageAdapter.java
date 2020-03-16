package com.android.veggitech.growapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.activity.BrinjalPlantDetailsActivity;
import com.android.veggitech.growapp.activity.CucumberPlantDetailsActivity;

public class PlantImageAdapter extends PagerAdapter {

    private Context context;
    int icons[] = {R.drawable.cucumber,R.drawable.tomato,R.drawable.brinjal, R.drawable.zucchini, R.drawable.swisschardnew};
    String iconsName[] = {"Cucumber", "Tomato", "Egg Plant", "Zucchini", "Swiss Chard"};
    LayoutInflater layoutInflater;
    View itemView;
    TextView plantName;
    ImageView plantImage;

    public PlantImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return icons.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((RelativeLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.month_plant, container,
                false);
        plantName = (TextView) itemView.findViewById(R.id.textViewPlantName);
        plantName.setTextColor(Color.parseColor("#FFFFFF"));
        plantName.setText(iconsName[position]);
        plantImage = (ImageView) itemView.findViewById(R.id.imageViewMonthPlant);
        plantImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
        plantImage.setImageResource(icons[position]);
        ((ViewPager) container).addView(itemView, 0);
        this.setupClickListener(plantImage, position);
        return itemView;

        /* ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(icons[position]);
        ((ViewPager) container).addView(imageView, 0);
        return imageView;*/
    }
    private void setupClickListener(final ImageView view, final int position) {

        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               // Toast.makeText(context, "ViewPager Click" + position, Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        try
                        {
                            Intent pagerIntent = new Intent(context, CucumberPlantDetailsActivity.class);
                            pagerIntent.putExtra("", position);
                            context.startActivity(pagerIntent);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    case 1:
                        Toast.makeText(context, "Launch Soon", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        try
                        {
                            Intent pagerIntent = new Intent(context, BrinjalPlantDetailsActivity.class);
                            pagerIntent.putExtra("", position);
                            context.startActivity(pagerIntent);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
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
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);
    }

}
