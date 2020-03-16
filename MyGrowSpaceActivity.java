package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.fragment.MyPlantFragment;
import com.android.veggitech.growapp.fragment.TipDetailsFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyGrowSpaceActivity extends AppCompatActivity {

    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FloatingActionButton floatingActionButton;
    Intent intent;
    String plantName;
    String plantDays, startDate, endDate;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_grow_space);

        plantName = getIntent().getStringExtra("name");
        plantDays =  getIntent().getStringExtra("days");
        startDate = getIntent().getStringExtra("start");
        endDate = getIntent().getStringExtra("end");
        bundle.putString("name", plantName);
        bundle.putString("days", plantDays);
        bundle.putString("start",startDate);
        bundle.putString("end", endDate);

        floatingActionButton = findViewById(R.id.fab_growspace);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), PlantActivity.class);
                startActivity(intent);

            }
        });

        fragment = new MyPlantFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

    }
}
