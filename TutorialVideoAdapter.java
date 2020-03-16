package com.android.veggitech.growapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.android.veggitech.growapp.R;

public class TutorialVideoAdapter extends PagerAdapter {

    private Context context;
    String video[] = {"android.resource://com.android.veggitech.growapp/"+R.raw.intro,"android.resource://com.android.veggitech.growapp/"+R.raw.seeding,"android.resource://com.android.veggitech.growapp/"+R.raw.transplanting};
    String iconsName[] = {"Intro Video", "Seeding Video", "Transplanting Video"};
    LayoutInflater layoutInflater;
    View itemView;
    TextView videoName;
    VideoView videoTutorial;
    MediaController mediaController;

    public TutorialVideoAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return video.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == ((RelativeLayout) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.tutorial_video, container,
                false);
        //videoName = (TextView) itemView.findViewById(R.id.videoTitle);
        videoName.setTextColor(Color.parseColor("#FFFFFF"));
        videoName.setText(iconsName[position]);
        videoTutorial = (VideoView) itemView.findViewById(R.id.videoViewTutorial);

      /*  Uri uri = Uri.parse(video[position]);
        //Uri uri = Uri.parse(String.valueOf(video[position]));
        videoTutorial.setVideoURI(uri);
        videoTutorial.setMediaController(mediaController);
        mediaController.setAnchorView(videoTutorial);
        videoTutorial.start();*/

        videoTutorial.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        MediaController mediaController = new MediaController(context, false);
        mediaController.setAnchorView(videoTutorial);
        videoTutorial.setMediaController(mediaController);
        mediaController.setAnchorView(videoTutorial);
        videoTutorial.start();
        ((ViewPager) container).addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((LinearLayout) object);
    }
}
