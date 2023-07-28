package com.maverix.TaskManagerBackend.services;

import com.maverix.TaskManagerBackend.models.Project;
import com.maverix.TaskManagerBackend.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(long id) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        return optionalProject.orElse(null);
    }

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(long id, Project updatedProject) {
        Optional<Project> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project project = optionalProject.get();
            project.setP_name(updatedProject.getP_name());
            project.setP_desc(updatedProject.getP_desc());
            project.setP_deadline(updatedProject.getP_deadline());
            project.setUser(updatedProject.getUser());
            return projectRepository.save(project);
        }
        return null;
    }

    @Override
    public void deleteProject(long id) {
        projectRepository.deleteById(id);
    }
}
