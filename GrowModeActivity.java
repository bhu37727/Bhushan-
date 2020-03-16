package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.GrowModeAdapter;
import com.android.veggitech.growapp.adapter.TutorialAdapter;
import com.android.veggitech.growapp.fragment.GrowModeFragment;
import com.android.veggitech.growapp.fragment.TipDetailsFragment;
import com.android.veggitech.growapp.model.GrowModel;
import com.android.veggitech.growapp.model.TutorialModel;

import java.util.ArrayList;

public class GrowModeActivity extends AppCompatActivity {

    Fragment fragment = null;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grow_mode);

        fragment = new GrowModeFragment();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        //fragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.grow_container, fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        fragmentTransaction.commit();
    }
}
