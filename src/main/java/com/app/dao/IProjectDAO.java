package com.app.dao;

import com.app.model.Project;

import java.util.List;

public interface IProjectDAO {
    public void saveProject(Project project);
    public Project getProjectById(String id);
    public List<Project> getAllProjects();
    public void updateProject(Project project);
    public void deleteProject(String id);
}
