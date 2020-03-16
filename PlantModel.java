package com.android.veggitech.growapp.model;

public class PlantModel {

    int image;
    String  data, title;

    public PlantModel() {
    }

    public PlantModel(int image, String data, String title) {
        this.image = image;
        this.data = data;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getData() {
        return data;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setData(String data) {
        this.data = data;
    }
}
