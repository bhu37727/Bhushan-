package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.GalleryImageAdapter;
import com.android.veggitech.growapp.adapter.ImagePagerAdapter;
import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;

public class GalleryImageFullScreenActivity extends AppCompatActivity {

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_image_full_screen);

        // Retrieve data from MainActivity on item click event
        Intent p = getIntent();
        position = p.getExtras().getInt("id");

        GalleryImageAdapter imageAdapter = new GalleryImageAdapter(this);
        List<ImageView> images = new ArrayList<ImageView>();

        // Retrieve all the images
        for (int i = 0; i < imageAdapter.getCount(); i++) {
            PhotoView photoView = new PhotoView(this);
            photoView.setImageResource(imageAdapter.images[i]);
            photoView.setScaleType(ImageView.ScaleType.CENTER);
            images.add(photoView);
        }

        // Set the images into ViewPager
        ImagePagerAdapter pageradapter = new ImagePagerAdapter(images);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpagerGallery);
        viewpager.setAdapter(pageradapter);
        // Show images following the position
        viewpager.setCurrentItem(position);
    }
}
