package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.fragment.HomeFragment;
import com.android.veggitech.growapp.fragment.TipDetailsFragment;
import com.squareup.picasso.Picasso;

import java.net.URI;
import java.net.URL;

public class TipDetailsActivity extends AppCompatActivity {

    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    String title, description, image;
    Bundle bundle;
    ImageView tipImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_details);
        //getSupportActionBar().hide();

        tipImage = findViewById(R.id.tipImageView);

        title = getIntent().getStringExtra("Title");
        description = getIntent().getStringExtra("Des");
        image = getIntent().getStringExtra("Image");
        Picasso.get().load(image).into(tipImage);

        bundle = new Bundle();
        bundle.putString("Title",title);
        bundle.putString("Des", description);
        //bundle.putString("Image", image);
        //bundle.putByteArray("Image", byteArray);*/

        fragment = new TipDetailsFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
