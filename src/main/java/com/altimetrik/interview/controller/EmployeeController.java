package com.altimetrik.interview.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.interview.handler.OrganizationApiResponse;
import com.altimetrik.interview.model.EmployeeResponse;
import com.altimetrik.interview.service.EmployeeDetailsService;
import com.altimetrik.interview.util.OrganizationServiceUtil;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	EmployeeDetailsService employeeDetailsService;

	@Autowired
	OrganizationServiceUtil orgServiceUtil;

	@GetMapping("/getEmployeeById/{empId}")
	public OrganizationApiResponse<EmployeeResponse> getEmployeeDetailsById(@PathVariable String empId) {
		logger.info("Request  received to fetch employee details. empId:{}", empId);

		var result = employeeDetailsService.fetchEmployeeDetailsById(empId);

		logger.info("Request Completed to fetch employee Details. Response->{}",
				result != null ? orgServiceUtil.convertObjectToJsonString(result) : result);

		return result;
	}
	
	@DeleteMapping("/dissociateEmployeeById/{empId}/{prjId}")
	public OrganizationApiResponse<String> dissociateEmployee(@PathVariable String empId,@PathVariable String prjId){
		logger.info("Request  received to dissociate employee from a project. empId:{}; prjId:{}", empId,prjId);

		var result = employeeDetailsService.dissociateEmployeeFromProject(empId,prjId);

		logger.info("Request Completed to dissociate employee from a project. Response->{}",
				result != null ? orgServiceUtil.convertObjectToJsonString(result) : result);

		return result;
	}
}
