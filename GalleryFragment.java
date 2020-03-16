package com.android.veggitech.growapp.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.activity.GalleryImageFullScreenActivity;
import com.android.veggitech.growapp.adapter.GalleryImageAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);

        GridView gallery = view.findViewById(R.id.gridViewGallery);
        GalleryImageAdapter galleryAdapter = new GalleryImageAdapter(this.getContext());
        gallery.setAdapter(galleryAdapter);

        gallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               /* Intent intent = new Intent(this, GalleryImageFullScreenActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);*/
                Intent intent = new Intent(getActivity(), GalleryImageFullScreenActivity.class);
                intent.putExtra("id", position);
                startActivity(intent);

            }
        });
        return view;
    }

}
