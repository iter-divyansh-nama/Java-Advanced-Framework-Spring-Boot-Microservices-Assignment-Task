package com.capgemini.model.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.capgemini.model.dto.Project;

@FeignClient(name = "project-service")
public interface ProjectFeignClient {
	@GetMapping("/projects/{id}")
	Project getProjectById(@PathVariable Integer id);
}