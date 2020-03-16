package com.android.veggitech.growapp.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.veggitech.growapp.R;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.google.android.material.tabs.TabLayout;

public class MaterialActivity extends AppCompatActivity {

    TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_viewpager);
        tabLayout = findViewById(R.id.tabLayoutPlantNew);
    }
}
