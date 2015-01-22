package com.app.logic;


import com.app.model.Widget;

import java.util.List;


public class WidgetFactory {
    private static WidgetFactory instance = null;

    private WidgetFactory() {
    }

    public static synchronized WidgetFactory getInstance(){
        if (instance == null) {
            instance = new WidgetFactory();
        }
        return instance;
    }

    public static List<Widget> getAllWidgets(String filePath) {
        JsonData<Widget> widgetJsonData = new JsonData<>();
        List<Widget> allWidgets = widgetJsonData.readFromFile(new Widget(), filePath);
        return allWidgets;
    }
}


