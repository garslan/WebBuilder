package com.app.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cooler on 15.01.2015.
 */
@XmlRootElement
public class Platform {
    private int id;
    private String name;
    private String sizeX;
    private String sizeY;
    private List<Widget> widgets;
    private List<Event> events;

    public Platform() {
        widgets = new ArrayList<>();
    }

    public void addWidgets(List<Widget> widgets){
        this.widgets.addAll(widgets);
    }

    public void addEvents(List<Event> events){
        this.events.addAll(events);
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSizeX() {
        return sizeX;
    }

    public void setSizeX(String sizeX) {
        this.sizeX = sizeX;
    }

    public String getSizeY() {
        return sizeY;
    }

    public void setSizeY(String sizeY) {
        this.sizeY = sizeY;
    }

    public List<Widget> getWidgets() {
        return widgets;
    }

    public void setWidgets(List<Widget> widgets) {
        this.widgets = widgets;
    }
}
