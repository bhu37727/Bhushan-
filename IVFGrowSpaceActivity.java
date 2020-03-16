package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.fragment.IVFFragment;
import com.android.veggitech.growapp.fragment.IVFGrowSpaceFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class IVFGrowSpaceActivity extends AppCompatActivity {

    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ivfgrow_space);

        floatingActionButton = findViewById(R.id.fab_ivf);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                PackageManager managerclock = getPackageManager();
                intent = managerclock.getLaunchIntentForPackage("com.agrivi.agrivi");
                intent.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(intent);
            }
        });

        fragment = new IVFGrowSpaceFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ivf_container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
