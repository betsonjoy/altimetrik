package com.altimetrik.interview.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.interview.handler.OrganizationApiResponse;
import com.altimetrik.interview.model.EmpPrjResponse;
import com.altimetrik.interview.model.ProjectResponse;
import com.altimetrik.interview.service.ProjectDetailsService;
import com.altimetrik.interview.util.OrganizationServiceUtil;

@RestController
@RequestMapping("/project")
public class ProjectController {

	Logger logger = LoggerFactory.getLogger(ProjectController.class);

	@Autowired
	ProjectDetailsService projectDetailsService;

	@Autowired
	OrganizationServiceUtil orgServiceUtil;

	@GetMapping("/getProjectByIdAndDepId/{prjId}/{depId}")
	public OrganizationApiResponse<ProjectResponse> getProjectDetailsById(@PathVariable String prjId, @PathVariable String depId) {
		logger.info("Request  received to fetch project details. prjId:{}; depId:{}", prjId, depId);

		var result = projectDetailsService.fetchProjectDetailsById(prjId, depId);

		logger.info("Request Completed to fetch project Details. Response->{}",
				result != null ? orgServiceUtil.convertObjectToJsonString(result) : result);

		return result;
	}

	@GetMapping("/getAllEmployeesOfProject/{prjId}")
	public OrganizationApiResponse<List<EmpPrjResponse>> getAllEmployeesOfProject(@PathVariable String prjId) {
		logger.info("Request  received to fetch project details. prjId:{}", prjId);

		var result = projectDetailsService.fetchAllEmpDetailsByProject(prjId);

		logger.info("Request Completed to fetch project Details. Response->{}",
				result != null ? orgServiceUtil.convertObjectToJsonString(result) : result);

		return result;
	}
}
