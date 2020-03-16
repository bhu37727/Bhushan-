package com.android.veggitech.growapp.model;

public class FvtPlantModel {
    int image;
    String plantName, plantDays, plantNumber;

    public FvtPlantModel() {
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setPlantDays(String plantDays) {
        this.plantDays = plantDays;
    }

    public void setPlantNumber(String plantNumber) {
        this.plantNumber = plantNumber;
    }

    public int getImage() {
        return image;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getPlantDays() {
        return plantDays;
    }

    public String getPlantNumber() {
        return plantNumber;
    }
}
