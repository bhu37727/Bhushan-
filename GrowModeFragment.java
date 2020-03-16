package com.android.veggitech.growapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.GrowModeAdapter;
import com.android.veggitech.growapp.model.GrowModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.

 */
public class GrowModeFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<GrowModel> arrayList;
    int images[] = {R.drawable.dutch, R.drawable.foam, R.drawable.ind, R.drawable.out};
    String numberPerSqm[] = {"4 Per Sqm", "4 Per Sqm", "1 Per Sqm", ""};
    String mode[] = {"Dutch Bucket", "Foam Bucket", "IVF Module", "Soil"};

    public GrowModeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grow_mode, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_grow_mode);
        arrayList = new ArrayList<>();

        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mGridLayoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < images.length; i++) {
            GrowModel growModel = new GrowModel();
            growModel.setImage(images[i]);
            growModel.setMode(mode[i]);
            growModel.setNumberPerSqm(numberPerSqm[i]);

            //add in array list
            arrayList.add(growModel);
        }

        GrowModeAdapter adapter = new GrowModeAdapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        return view;
    }

}
