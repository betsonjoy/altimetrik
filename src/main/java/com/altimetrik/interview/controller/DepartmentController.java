package com.altimetrik.interview.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.interview.handler.OrganizationApiResponse;
import com.altimetrik.interview.model.DepartmentResponse;
import com.altimetrik.interview.service.DepartmentDetailsService;
import com.altimetrik.interview.util.OrganizationServiceUtil;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	DepartmentDetailsService depService;

	@Autowired
	OrganizationServiceUtil orgServiceUtil;

	@GetMapping("/getDepartmentById/{depId}")
	public OrganizationApiResponse<DepartmentResponse> getDepartmentDetailsById(@PathVariable String depId) {

		logger.info("Request  received to fetch department details. depId:{}", depId);

		var result = depService.fetchDepartmentDetailsById(depId);

		logger.info("Request Completed to fetch department Details. Response->{}",
				result != null ? orgServiceUtil.convertObjectToJsonString(result) : result);

		return result;
	}
}
