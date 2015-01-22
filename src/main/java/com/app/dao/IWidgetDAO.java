package com.app.dao;

import com.app.model.Widget;

import java.util.List;

/**
 * Created by cooler on 17.01.2015.
 */
public interface IWidgetDAO {
    public void saveWidget(Widget widget);
    public Widget getWidgetById(String id);
    public List<Widget> getAllWidgets();
    public void updateWidget(Widget widget);
    public void deleteWidget(String id);
}
