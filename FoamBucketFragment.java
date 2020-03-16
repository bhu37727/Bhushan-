package com.android.veggitech.growapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.activity.MyGrowSpaceActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FoamBucketFragment extends Fragment {

    Button buttonContinue;
    Intent intent;

    public FoamBucketFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_foam_bucket, container, false);
        buttonContinue = view.findViewById(R.id.buttonFoamContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), MyGrowSpaceActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        return view;
    }

}
