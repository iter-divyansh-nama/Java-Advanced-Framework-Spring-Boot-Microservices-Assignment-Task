package com.capgemini.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.entity.Project;
import com.capgemini.model.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepository;
	
	public Project getProjectById(Integer id) {
	    return projectRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
	}
	
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}
	
	public List<Project> saveProjects(List<Project> projects) {
		return projectRepository.saveAll(projects);
	}
}