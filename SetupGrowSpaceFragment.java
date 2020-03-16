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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.activity.GrowModeActivity;
import com.android.veggitech.growapp.activity.SignupActivity;
import com.android.veggitech.growapp.database.DbHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class SetupGrowSpaceFragment extends Fragment {

    Button createGrowSpace;
    Spinner locationSpinner;
    EditText length, width;
    String location, growLength, growWidth;
    Intent intent;
    Double gLength, gWidth;

    public SetupGrowSpaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_setup_grow_space, container, false);
        locationSpinner = view.findViewById(R.id.spinnerLocation);
        length = view.findViewById(R.id.editTextLength);
        length.setHint("Length (m)");
        width = view.findViewById(R.id.editTextWidth);
        width.setHint("Width (m)");
        createGrowSpace = view.findViewById(R.id.buttonCreate);
        createGrowSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                location = locationSpinner.getSelectedItem().toString();
                growLength = length.getText().toString();
                gLength = Double.parseDouble(growLength);
                growWidth = width.getText().toString();
                gWidth = Double.parseDouble(growWidth);
                if(gLength == null){
                    Toast.makeText(getActivity(), "Please fill all fields!!!", Toast.LENGTH_LONG).show();
                }
                else if(gWidth == null){
                    Toast.makeText(getActivity(), "Please fill all fields!!!", Toast.LENGTH_LONG).show();
                }
               /* DbHandler dbHandler = new DbHandler(getActivity());
                dbHandler.insertGrowSpaceDetails(location,gLength,gWidth);*/
                Toast.makeText(getActivity(), "Your Grow Space Created Successfully...",Toast.LENGTH_SHORT).show();
                intent = new Intent(getActivity(), GrowModeActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }


}
