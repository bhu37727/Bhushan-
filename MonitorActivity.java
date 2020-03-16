package com.android.veggitech.growapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.android.veggitech.growapp.R;

public class MonitorActivity extends AppCompatActivity {

    ImageButton simpleImageButtonHome;
    ImageButton simpleImageButtonYouTube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        simpleImageButtonHome = (ImageButton)findViewById(R.id.simpleImageButtonHome);
        simpleImageButtonYouTube = (ImageButton)findViewById(R.id.simpleImageButtonYouTube);
        simpleImageButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
