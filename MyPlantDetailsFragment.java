package com.android.veggitech.growapp.fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.GrowthStageAdapter;
import com.android.veggitech.growapp.adapter.TutorialAdapter;
import com.android.veggitech.growapp.model.GrowthStageModel;
import com.android.veggitech.growapp.model.TutorialModel;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyPlantDetailsFragment extends Fragment {

    double plantHeight = 59.1;
    int[] yAxisData = {1, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60};
    String[] axisData  = {"1","2","3","4","5","6","7","8","9","10","11","12"};
    LineChartView lineChartPlant;
    List yAxisValues;
    List axisValues;
    Line line;
    String startDate, endDate;
    TextView textViewStart, textViewEnd;
    Bundle bundle = new Bundle();
    RecyclerView recyclerView;
    ArrayList<GrowthStageModel> arrayList = new ArrayList<GrowthStageModel>();
    String stageName[] = {"Nursing Stage", "Transplanting Stage", "Vegetative Growth", "Flowering Stage", "Fruiting Stage", "Harvesting Stage"};
    String stageDescription[] = {"Sow cucumbers from mid spring into small pots of seed starting or general-purpose potting mix. Sow two seeds about an inch (3cm) deep, then water well.\n" +
            "Cucumbers need temperatures of at least 68ºF (20ºC) to germinate. Remove the weakest to leave one per pot.",
            "Cucumber plants should be seeded or transplanted outside in the ground no earlier than 2 weeks after the last frost date. Cucumbers are extremely susceptible to frost and cold damage; the soil must be at least 70ºF for germination.",
            "Stage I – Upright growth is the initial stage that starts when first true leaves emerge and it ends after 5-6 nodes.\n" +
            "Stage II – Vining - starts after 6 nodes. Then, side shoots begin to emerge from leaf axils, while main leader continues to grow. Side shoots are also growing, causing the plant to flop over.",
    "Cucumbers produce two kinds of bright, golden-yellow flowers: male and female. Male flowers emerge first but do not produce fruits and fall off after pollination is complete. Female flowers emerge within one to two weeks.\n" +
            "Cucumber plants are not self-pollinating; they require bees or other pollinators to carry their pollen from male flowers to female flowers.",
    "After female cucumber flowers have been pollinated, they swell at their bases and begin to develop into fruits.  The first male flower would be seen within 35 to 55 days roughly, which will be later followed by developing a female flower in one or two weeks (i.e., 42 to 62 days).\n" +
            "The fertilized female flower will take 10 to 12 days to produce fruits.",
    "Harvest. Depending on the variety, cucumbers will be ready to harvest between 48 and 76 days from germination. As a fast-growing plant, you can stagger planting cucumbers every couple of weeks to provide a steady supply throughout the summer. Cucumbers are eaten when still immature, before their seeds have hardened."};

    int image1[] = {R.drawable.cucu1, R.drawable.trans3, R.drawable.g1, R.drawable.fl1, R.drawable.fr1, R.drawable.cucumber};
    int image2[] = {R.drawable.cucu2, R.drawable.trans1, R.drawable.g2, R.drawable.fl2, R.drawable.fr2, R.drawable.hr2};
    int image3[] = {R.drawable.cucu3, R.drawable.trans2, R.drawable.f1, R.drawable.fl3, R.drawable.fr3, R.drawable.cucuharvest};

    public MyPlantDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_plant_details, container, false);

        bundle = getArguments();
        startDate = bundle.getString("start");
        endDate = bundle.getString("end");

        textViewStart = view.findViewById(R.id.textViewStartDate);
        textViewStart.setText(startDate);
        textViewEnd = view.findViewById(R.id.textViewEndDate);
        textViewEnd.setText(endDate);

        recyclerView = view.findViewById(R.id.recycler_view_my_plant);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < image1.length; i++) {
            GrowthStageModel stageModel = new GrowthStageModel();
            stageModel.setImage1(image1[i]);
            stageModel.setImage2(image2[i]);
            stageModel.setImage3(image3[i]);
            stageModel.setStageName(stageName[i]);
            stageModel.setStageDes(stageDescription[i]);

            //add in array list
            arrayList.add(stageModel);
        }

        GrowthStageAdapter adapter = new GrowthStageAdapter(this.getActivity(), arrayList);
        recyclerView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        return  view;
    }
}
