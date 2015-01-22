package com.app.dao.impl;

import com.app.dao.IWidgetDAO;
import com.app.model.Widget;
import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.File;


@Component
public class WidgetDAOImpl implements IWidgetDAO {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(WidgetDAOImpl.class);
    private static final String WIDGET_FOLDER_PATH = "/Volumes/Fat32/=Java=/data/widget/";

    private Gson jSon = new Gson();

    @Override
    public void saveWidget(Widget widget) {
        if (widget == null) {
            return;
        }

        String filePath = WIDGET_FOLDER_PATH + widget.getId() + ".txt";

        try (FileWriter writer = new FileWriter(filePath, false))
        {
            String jsonObj = jSon.toJson(widget);
            writer.write(jsonObj);

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    @Override
    public Widget getWidgetById(String id) {
        String filePath = WIDGET_FOLDER_PATH + id + ".txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                String objStr = reader.readLine();
                Widget widget = jSon.fromJson(objStr, Widget.class);
                if (widget != null) {
                    return widget;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Widget> getAllWidgets() {
        List<Widget> list = new ArrayList<>();

        File folder = new File(WIDGET_FOLDER_PATH);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null)
           logger.debug("list of widget files size: " + listOfFiles.length);
        else
            logger.debug("list of widget is null!");

        if (listOfFiles != null && listOfFiles.length > 0) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    String id = file.getName().substring(0, file.getName().lastIndexOf(".txt"));

                    Widget tempWidget = getWidgetById(id);
                    if (tempWidget != null) {
                        list.add(tempWidget);
                    }
                }
            }
        }

        return list;
    }


    @Override
    public void updateWidget(Widget widget) {

    }

    @Override
    public void deleteWidget(String id) {

    }
}
