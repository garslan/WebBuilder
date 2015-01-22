package com.app.service;

import com.app.model.Widget;
import java.util.List;

public interface IWidgetService {
        public void saveWidget(Widget widget);
        public Widget getWidgetById(String id);
        public List<Widget> getAllWidgets();
        public void updateWidget(Widget widget);
        public void deleteWidget(String id);
}
