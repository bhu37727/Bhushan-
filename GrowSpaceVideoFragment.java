package com.android.veggitech.growapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.android.veggitech.growapp.R;
import com.android.veggitech.growapp.adapter.PlantImageAdapter;
import com.android.veggitech.growapp.adapter.TutorialVideoAdapter;

import me.relex.circleindicator.CircleIndicator;

/**
 * A simple {@link Fragment} subclass.
 */
public class GrowSpaceVideoFragment extends Fragment {

    VideoView videoViewIntro, videoViewSeeding, videoViewTransplanting;
    MediaController mediaController;
    String videoPathIntro = "android.resource://com.android.veggitech.growapp/"+R.raw.intro;
    String videoPathSeeding = "android.resource://com.android.veggitech.growapp/"+R.raw.seeding;
    String videoPathTransplant = "android.resource://com.android.veggitech.growapp/"+R.raw.transplanting;
    ViewPager viewPager;
    CircleIndicator circleIndicator;

    public GrowSpaceVideoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grow_space_video, container, false);
        mediaController = new MediaController(getActivity());

       /* viewPager = view.findViewById(R.id.viewPagerVideo);
        TutorialVideoAdapter videoAdapter = new TutorialVideoAdapter(getActivity());
        viewPager.setAdapter(videoAdapter);

        circleIndicator = view.findViewById(R.id.indicatorVideo);
        circleIndicator.setViewPager(viewPager);*/

        videoViewIntro = view.findViewById(R.id.videoViewIntro);
        Uri uri = Uri.parse(videoPathSeeding);
        videoViewIntro.setVideoURI(uri);
        videoViewIntro.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewIntro);
        videoViewIntro.start();

      /*  videoViewSeeding = view.findViewById(R.id.videoViewSeeding);
        uri = Uri.parse(videoPathSeeding);
        videoViewSeeding.setVideoURI(uri);
        videoViewSeeding.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewSeeding);
        videoViewSeeding.pause();

        videoViewTransplanting = view.findViewById(R.id.videoViewTransplant);
        uri = Uri.parse(videoPathTransplant);
        videoViewTransplanting.setVideoURI(uri);
        videoViewTransplanting.setMediaController(mediaController);
        mediaController.setAnchorView(videoViewTransplanting);
        videoViewTransplanting.pause();*/

        return view;
    }
}
