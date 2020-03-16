package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.fragment.GrowSapceTutorialFragment;
import com.android.veggitech.growapp.fragment.SetupGrowSpaceFragment;

public class SetUpGrowSpaceActivity extends AppCompatActivity {

    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_grow_space);

        fragment = new SetupGrowSpaceFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        // fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.setup_container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
