package com.maverix.TaskManagerBackend.services;

import com.maverix.TaskManagerBackend.models.Project;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();

    Project getProjectById(long id);

    Project createProject(Project project);

    Project updateProject(long id, Project project);

    void deleteProject(long id);
}
