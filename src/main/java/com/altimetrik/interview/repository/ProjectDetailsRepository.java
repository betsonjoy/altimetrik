package com.altimetrik.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.altimetrik.interview.model.Project;

public interface ProjectDetailsRepository extends JpaRepository<Project, String> {

	public Project findByProjectIdAndDepartmentId(String prjId, String depId);
	
	public List<Project> findByProjectId(String prjId);
}
