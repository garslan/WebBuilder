package com.app.logic;

import com.app.dao.impl.ProjectDAOImpl;
import com.app.model.Project;

import java.util.UUID;


public class Generate {
    public static void main(String[] args) {

        //Generate widgets
        WidgetDAOImpl widgetDAO = new WidgetDAOImpl();

        for (int i = 0; i < 10; i++) {
            Widget widget = new Widget();
            widget.setId(String.valueOf(UUID.randomUUID()));
            widget.setName("Widget-" + i);
            widget.setImageUrl("images/widgets/" + i);

            Map<String, String> settings = new HashMap<>();
            for (int j = 0; j < 5; j++) {
                settings.put("text" + j, "textvalue" + j);
            }
            widget.setSettings(settings);
            widgetDAO.saveWidget(widget);
        }


        //Generate projects
        ProjectDAOImpl projectDAO = new ProjectDAOImpl();

        for (int i = 0; i < 5; i++) {
            Project project = new Project();
            project.setId(String.valueOf(UUID.randomUUID()));
            project.setName("Project-" + i);

            projectDAO.saveProject(project);
        }

    }
}
