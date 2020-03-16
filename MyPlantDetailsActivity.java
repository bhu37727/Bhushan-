package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.fragment.MyPlantDetailsFragment;
import com.android.veggitech.growapp.fragment.TipDetailsFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyPlantDetailsActivity extends AppCompatActivity {

    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FloatingActionButton floatingActionButton;
    Intent intent;
    String startDate, endDate;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_plant_details);

        startDate = getIntent().getStringExtra("start");
        endDate = getIntent().getStringExtra("end");
        bundle.putString("start", startDate);
        bundle.putString("end", endDate);

        floatingActionButton = findViewById(R.id.fab_monitor);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), PlantGrowthMonitorActivity.class);
                startActivity(intent);
            }
        });

        fragment = new MyPlantDetailsFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
