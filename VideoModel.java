package com.android.veggitech.growapp.model;

public class VideoModel {
    private  String video;
    private String preview;

    public VideoModel() {
    }

    public VideoModel(String video, String preview) {
        this.video = video;
        this.preview = preview;
    }

    public String getVideo() {
        return video;
    }

    public String getPreview() {
        return preview;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
