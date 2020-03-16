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

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.BrinjalPlantAdapter;
import com.android.veggitech.growapp.adapter.CustomCucumberPlantAdapter;
import com.android.veggitech.growapp.javaclass.ViewDialog;
import com.android.veggitech.growapp.model.PlantModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BrinjalAboutPlantFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BrinjalAboutPlantFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BrinjalAboutPlantFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    TableLayout tableLayout;
    TableRow tableRowSow, tableRowBloom, tableRowHarvest;
    ArrayList<PlantModel> arrayList;
    RecyclerView recyclerView;
    int[] icon = {R.drawable.sowd, R.drawable.distance, R.drawable.growm, R.drawable.plantspersqm, R.drawable.germination, R.drawable.transplanting, R.drawable.outdoor, R.drawable.height, R.drawable.harvest, R.drawable.temperature, R.drawable.ph};
    //String[] iconTitle = {"Sow Depth", "Distance b/n Plants", "Grow Mode", "Plants Per SqM", "Germination Period", "Transplanting Time", "Planting Location", "Plant Height", "Harvest Period", "Min Temperature", "Minimum PH"};
    String[] iconData = {"1 cm", "40 cm", "Dutch/Soil", "4 Plants", "10 Days", "9 Weeks", "Indoor/Outdoor", "100 cm", "90 Days", "27\u00B0 C", "6.2"};


    public BrinjalAboutPlantFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BrinjalAboutPlantFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BrinjalAboutPlantFragment newInstance(String param1, String param2) {
        BrinjalAboutPlantFragment fragment = new BrinjalAboutPlantFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_brinjal_about_plant, container, false);
        tableLayout = view.findViewById(R.id.tableLayoutBrinjalPlant);
        tableRowSow = view.findViewById(R.id.tableRowbSow);
        tableRowSow.setClickable(true);
        tableRowSow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity());
                //Toast.makeText(getActivity(), "Row Clicked", Toast.LENGTH_LONG).show();
            }
        });

        tableRowBloom = view.findViewById(R.id.tableRowBbloom);
        tableRowBloom.setClickable(true);
        tableRowBloom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity());
                //Toast.makeText(getActivity(), "Row Clicked", Toast.LENGTH_LONG).show();
            }
        });

        tableRowHarvest = view.findViewById(R.id.tableRowbHarvest);
        tableRowHarvest.setClickable(true);
        tableRowHarvest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewDialog alert = new ViewDialog();
                alert.showDialog(getActivity());
                //Toast.makeText(getActivity(), "Row Clicked", Toast.LENGTH_LONG).show();
            }
        });
        recyclerView = view.findViewById(R.id.recycler_view_plant_brinjal);
        arrayList = new ArrayList<>();
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recyclerView.setLayoutManager(mGridLayoutManager);
        //recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < icon.length; i++) {
            PlantModel plantModel = new PlantModel();
            plantModel.setImage(icon[i]);
            plantModel.setData(iconData[i]);

            //add in array list
            arrayList.add(plantModel);
        }

        BrinjalPlantAdapter adapter = new BrinjalPlantAdapter(this.getContext(), arrayList);
        recyclerView.setAdapter(adapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
