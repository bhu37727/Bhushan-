package com.android.veggitech.growapp.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class TipDetailsFragment extends Fragment {

    TextView title, description;
    String tipTitle, tipDes;
    Bundle bundle;
    byte[] byteArray;
    Bitmap bitmap;

    public TipDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tip_details, container, false);
        title = view.findViewById(R.id.textViewTipTitle);
        description = view.findViewById(R.id.textViewDescription);
        bundle = getArguments();
        tipTitle = bundle.getString("Title");
        tipDes = bundle.getString("Des");
        //tipImage = bundle.getString("Image");
        //title.setText(String.valueOf(bundle.getString("Title")));
        //Toast.makeText(getActivity(), "Tip Data" +tipTitle, Toast.LENGTH_LONG).show();
        // tipTitle = getIntent().getStringExtra("Title");
       // tipDes = getIntent().getStringExtra("Des");
        title.setText(tipTitle);
        description.setText(tipDes);

        return view;
    }
}
