package com.android.veggitech.growapp.model;

public class PlantItemModel {

    String plantName, plantSqm, harvestPeriod, imageUrl;

    public PlantItemModel() {
    }

    public PlantItemModel(String plantName, String plantSqm, String harvestPeriod, String imageUrl) {
        this.plantName = plantName;
        this.plantSqm = plantSqm;
        this.harvestPeriod = harvestPeriod;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public void setPlantSqm(String plantSqm) {
        this.plantSqm = plantSqm;
    }

    public void setHarvestPeriod(String harvestPeriod) {
        this.harvestPeriod = harvestPeriod;
    }

    public String getPlantName() {
        return plantName;
    }

    public String getPlantSqm() {
        return plantSqm;
    }

    public String getHarvestPeriod() {
        return harvestPeriod;
    }
}
