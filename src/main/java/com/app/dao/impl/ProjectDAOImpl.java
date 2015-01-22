package com.app.dao.impl;

import com.app.dao.IProjectDAO;
import com.app.model.Project;
import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectDAOImpl implements IProjectDAO {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProjectDAOImpl.class);
    private static final String PROJECT_FOLDER_PATH = "/Volumes/Fat32/=Java=/data/project/";
    private Gson jSon = new Gson();

        @Override
        public void saveProject(Project project) {
            if (project == null) {
                return;
            }

            String filePath = PROJECT_FOLDER_PATH + project.getId() + ".txt";

            try (FileWriter writer = new FileWriter(filePath, false))
            {
                String jsonObj = jSon.toJson(project);
                writer.write(jsonObj);

            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }

        @Override
        public Project getProjectById(String id) {
            String filePath = PROJECT_FOLDER_PATH + id + ".txt";

            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                while (reader.ready()) {
                    String objStr = reader.readLine();
                    Project project = jSon.fromJson(objStr, Project.class);
                    if (project != null) {
                        return project;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        public List<Project> getAllProjects() {
            List<Project> list = new ArrayList<>();

            File folder = new File(PROJECT_FOLDER_PATH);
            File[] listOfFiles = folder.listFiles();

            if (listOfFiles != null && listOfFiles.length > 0) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        String id = file.getName().substring(0, file.getName().lastIndexOf(".txt"));

                        Project tempProject = getProjectById(id);
                        if (tempProject != null) {
                            list.add(tempProject);
                        }
                    }
                }
            }

            return list;
        }


        @Override
        public void updateProject(Project project) {

        }

        @Override
        public void deleteProject(String id) {

        }
}
