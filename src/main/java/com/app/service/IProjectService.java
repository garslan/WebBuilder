package com.app.service;

import com.app.model.Project;

import java.util.List;


public interface IProjectService {
    public void saveProject(Project project);
    public Project getProjectById(String id);
    public List<Project> getAllProjects();
    public void updateProject(Project project);
    public void deleteProject(String id);
}
