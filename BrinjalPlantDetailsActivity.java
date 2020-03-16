package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.net.Uri;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.fragment.BrinjalAboutPlantFragment;
import com.android.veggitech.growapp.fragment.BrinjalDiseaseFragment;
import com.android.veggitech.growapp.fragment.BrinjalSeedFragment;
import com.android.veggitech.growapp.fragment.BrinjalVideoFragment;
import com.android.veggitech.growapp.fragment.CucumberAboutPlantFragment;
import com.android.veggitech.growapp.fragment.CucumberAttackFragment;
import com.android.veggitech.growapp.fragment.CucumberSeedFragment;
import com.android.veggitech.growapp.fragment.CucumberVideoFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class BrinjalPlantDetailsActivity extends AppCompatActivity implements BrinjalAboutPlantFragment.OnFragmentInteractionListener {

    FrameLayout frameLayout;
    TabLayout tabLayoutPlant;
    Fragment fragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FloatingActionButton floatingButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brinjal_plant_details);
        //getSupportActionBar().hide();

        frameLayout = findViewById(R.id.frame_container_brinjal);
        tabLayoutPlant = findViewById(R.id.tabLayoutBrinjalPlant);
        floatingButton = findViewById(R.id.fabbrinjal);

        fragment = new BrinjalAboutPlantFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container_brinjal, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();

        tabLayoutPlant.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment = null;
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new BrinjalAboutPlantFragment();
                        break;
                    case 1:
                        fragment = new BrinjalSeedFragment();
                        break;
                    case 2:
                        fragment = new BrinjalDiseaseFragment();
                        break;
                    case 3:
                        fragment = new BrinjalVideoFragment();
                        break;
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container_brinjal, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
