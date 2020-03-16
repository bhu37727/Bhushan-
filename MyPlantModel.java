package com.android.veggitech.growapp.model;

public class MyPlantModel {
    int image, plantDays, plantLeft;
    String plantName, startDate, endDate;

    public MyPlantModel() {
    }

    public MyPlantModel(int image, int plantDays, int plantLeft, String plantName, String startDate, String endDate) {
        this.image = image;
        this.plantDays = plantDays;
        this.plantLeft = plantLeft;
        this.plantName = plantName;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getImage() {
        return image;
    }

    public int getPlantDays() {
        return plantDays;
    }

    public int getPlantLeft() {
        return plantLeft;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setPlantDays(int plantDays) {
        this.plantDays = plantDays;
    }

    public void setPlantLeft(int plantLeft) {
        this.plantLeft = plantLeft;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
