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
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.CustomCucumberPlantAdapter;
import com.android.veggitech.growapp.javaclass.ViewDialog;
import com.android.veggitech.growapp.model.PlantModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CucumberAboutPlantFragment extends Fragment {
    private OnFragmentInteractionListener mListener;

    TableLayout tableLayout;
    TableRow tableRowSow, tableRowBloom, tableRowHarvest;
    ArrayList<PlantModel> arrayList;
    RecyclerView recyclerView;
    View view;
    int[] icon = {R.drawable.sowd, R.drawable.distance, R.drawable.growm, R.drawable.plantspersqm, R.drawable.germination, R.drawable.transplanting, R.drawable.outdoor, R.drawable.height, R.drawable.cucuharvest, R.drawable.temperature, R.drawable.ph};
   String[] iconTitle = {"Sow Depth", "Distance b/n Plants", "Grow Mode", "Plants Per SqM", "Germination Period", "Transplanting Time", "Planting Location", "Plant Height", "Harvest Period", "Min Temperature", "Minimum PH"};
    String[] iconData = {"2 cm", "30 cm", "Dutch/Soil", "4 Plants", "10 Days", "3 Weeks", "Indoor/Outdoor", "150 cm", "65 Days", "21\u00B0 C", "6.0"};

    public CucumberAboutPlantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.cucumber_fragment_about_plant, container, false);
        tableLayout = view.findViewById(R.id.tableLayoutPlant);
        tableRowSow = view.findViewById(R.id.tableRowSow);
        tableRowSow.setClickable(true);
        tableRowSow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity());
                //Toast.makeText(getActivity(), "Row Clicked", Toast.LENGTH_LONG).show();
            }
        });

        tableRowBloom = view.findViewById(R.id.tableRowBloom);
        tableRowBloom.setClickable(true);
        tableRowBloom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity());
                //Toast.makeText(getActivity(), "Row Clicked", Toast.LENGTH_LONG).show();
            }
        });

        tableRowHarvest = view.findViewById(R.id.tableRowHarvest);
        tableRowHarvest.setClickable(true);
        tableRowHarvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity());
                //Toast.makeText(getActivity(), "Row Clicked", Toast.LENGTH_LONG).show();
            }
        });
        recyclerView = view.findViewById(R.id.recycler_view_plant);
        arrayList = new ArrayList<>();
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(mGridLayoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < icon.length; i++) {
            PlantModel plantModel = new PlantModel();
            plantModel.setImage(icon[i]);
            plantModel.setData(iconData[i]);
            plantModel.setTitle(iconTitle[i]);

            //add in array list
            arrayList.add(plantModel);
        }

        CustomCucumberPlantAdapter adapter = new CustomCucumberPlantAdapter(this.getContext(), arrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
