package com.android.veggitech.growapp.model;

public class GrowModel {
    String mode, numberPerSqm;
    int image;

    public GrowModel() {
    }

    public GrowModel(String mode, String numberPerSqm, int image) {
        this.mode = mode;
        this.numberPerSqm = numberPerSqm;
        this.image = image;
    }

    public String getMode() {
        return mode;
    }

    public String getNumberPerSqm() {
        return numberPerSqm;
    }

    public int getImage() {
        return image;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setNumberPerSqm(String numberPerSqm) {
        this.numberPerSqm = numberPerSqm;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
