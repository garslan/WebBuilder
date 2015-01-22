package com.app.model;

import java.util.Map;

public class Widget {
    private String id;
    private String name;
    private String imageUrl;
    private String coordX;
    private String coordY;
    private Map<String, String> settings;

    public Widget() {
    }

    public Widget(String id, String name, String imageUrl, String coordX, String coordY, Map<String, String> settings) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.coordX = coordX;
        this.coordY = coordY;
        this.settings = settings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, String> settings) {
        this.settings = settings;
    }
}
