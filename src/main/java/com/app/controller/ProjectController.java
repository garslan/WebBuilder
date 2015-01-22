package com.app.controller;

import com.app.model.Project;
import com.app.model.Widget;
import com.app.service.IProjectService;
import com.app.service.IWidgetService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;


@Controller
public class ProjectController {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ProjectController.class);
    private static final String DEFAULT_PROJECT_NAME = "Default";

    @Autowired
    public IWidgetService widgetService;

    @Autowired
    public IProjectService projectService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String project(Model model) {
        List<Project> allProjects = projectService.getAllProjects();
        int projectAmount = allProjects.size();
        Project project = new Project();

        model.addAttribute("projectAmount", projectAmount);
        model.addAttribute("project", project);
        return "createProject";
    }

    @RequestMapping(value = "/project/all", method = RequestMethod.GET)
    public String getAllProjects(Model model){
        List<Project> allProjects = projectService.getAllProjects();

        model.addAttribute("allProjects", allProjects);
        return "listProject";
    }

    @RequestMapping(value = "/project/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("project") Project project, Model model) {
        if (project == null) {
            return "createProject";
        }



        if (project.getId() == null || project.getId().equals("")){
            String uuid = String.valueOf(UUID.randomUUID());
            project.setId(uuid);
            logger.debug("Generated uuid for new project.");

            if (project.getName() == null || project.getName().equals("")){
                project.setName(DEFAULT_PROJECT_NAME);

            }
        } else {
            project = projectService.getProjectById(project.getId());
        }

        List<Widget> allBaseWidgets = widgetService.getAllWidgets();

        model.addAttribute("allBaseWidgets", allBaseWidgets);
        model.addAttribute("project", project);
        return "editProject";
    }

    @RequestMapping(value = "/project/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") String projectId, Model model) {
        if (projectId == null) {
            return "listProject";
        }

        Project project = projectService.getProjectById(projectId);
        List<Widget> allBaseWidgets = widgetService.getAllWidgets();

        model.addAttribute("allBaseWidgets", allBaseWidgets);
        model.addAttribute("project", project);
        return "editProject";
    }


    @RequestMapping(value = "/project/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("project") Project project, Model model) {
        if (project == null) {
            return "editProject";
        }

        projectService.saveProject(project);

        List<Widget> allBaseWidgets = widgetService.getAllWidgets();

        model.addAttribute("allBaseWidgets", allBaseWidgets);
        model.addAttribute("project", project);
        return "editProject";
    }

}
