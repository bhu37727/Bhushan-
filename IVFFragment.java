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
import com.android.veggitech.growapp.activity.IVFGrowSpaceActivity;
import com.android.veggitech.growapp.activity.MyGrowSpaceActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class IVFFragment extends Fragment {

    Button buttonContinue;
    Intent intent;

    public IVFFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_ivf, container, false);

        buttonContinue = view.findViewById(R.id.buttonIVFContinue);
        buttonContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getActivity(), IVFGrowSpaceActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        return view;
    }
}
