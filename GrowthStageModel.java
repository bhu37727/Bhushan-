package com.android.veggitech.growapp.model;

public class GrowthStageModel {
    int image1, image2, image3;
    String stageName, stageDes;

    public GrowthStageModel() {
    }

    public GrowthStageModel(int image1, int image2, int image3, String stageName, String stageDes) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.stageName = stageName;
        this.stageDes = stageDes;
    }

    public int getImage1() {
        return image1;
    }

    public int getImage2() {
        return image2;
    }

    public int getImage3() {
        return image3;
    }

    public String getStageName() {
        return stageName;
    }

    public String getStageDes() {
        return stageDes;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public void setImage3(int image3) {
        this.image3 = image3;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public void setStageDes(String stageDes) {
        this.stageDes = stageDes;
    }
}
