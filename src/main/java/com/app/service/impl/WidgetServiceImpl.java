package com.app.service.impl;

import com.app.dao.IWidgetDAO;
import com.app.model.Widget;
import com.app.service.IWidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetServiceImpl implements IWidgetService {

    @Autowired
    private IWidgetDAO widgetDAO;

    @Override
    public void saveWidget(Widget widget) {
        widgetDAO.saveWidget(widget);
    }

    @Override
    public Widget getWidgetById(String id) {
        return widgetDAO.getWidgetById(id);
    }

    @Override
    public List<Widget> getAllWidgets() {
        return widgetDAO.getAllWidgets();
    }

    @Override
    public void updateWidget(Widget widget) {
        widgetDAO.updateWidget(widget);
    }

    @Override
    public void deleteWidget(String id) {
        widgetDAO.deleteWidget(id);
    }
}
