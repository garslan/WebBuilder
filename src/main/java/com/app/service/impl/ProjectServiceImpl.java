package com.app.service.impl;

import com.app.dao.IProjectDAO;
import com.app.model.Project;
import com.app.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements IProjectService {

    @Autowired
    private IProjectDAO projectDAO;

    @Override
    public void saveProject(Project project) {
        projectDAO.saveProject(project);
    }

    @Override
    public Project getProjectById(String id) {
        return projectDAO.getProjectById(id);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectDAO.getAllProjects();
    }

    @Override
    public void updateProject(Project project) {
        projectDAO.updateProject(project);
    }

    @Override
    public void deleteProject(String id) {
        projectDAO.deleteProject(id);
    }
}
