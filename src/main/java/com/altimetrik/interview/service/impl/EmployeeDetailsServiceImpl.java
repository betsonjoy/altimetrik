package com.altimetrik.interview.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.interview.handler.OrganizationApiResponse;
import com.altimetrik.interview.model.Employee;
import com.altimetrik.interview.model.EmployeeResponse;
import com.altimetrik.interview.repository.EmployeeDetailsRepository;
import com.altimetrik.interview.service.EmployeeDetailsService;
import com.altimetrik.interview.util.Constants;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
	Logger logger = LoggerFactory.getLogger(EmployeeDetailsServiceImpl.class);

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepo;

	@Override
	public OrganizationApiResponse<EmployeeResponse> fetchEmployeeDetailsById(String empId) {
		var employeeApiResponse = new OrganizationApiResponse<EmployeeResponse>();
		var depName = new ArrayList<String>();
		var prjName = new ArrayList<String>();
		var empResponse = new EmployeeResponse();
		try {
			logger.info("Starts fetchEmployeeDetailsById({}) ", empId);
			Optional<Employee> empOpt = employeeDetailsRepo.findById(empId);
			if (!empOpt.isEmpty()) {
				var emp = empOpt.get();
				emp.getDepartment().stream().forEach(d -> {
					depName.add(d.getDepartmentName());
				});
				emp.getProject().stream().forEach(p -> {
					prjName.add(p.getProjectName());
				});
				empResponse.setEmployeeId(emp.getEmployeeId());
				empResponse.setEmployeeName(emp.getEmployeeName());
				empResponse.setDepartmentName(depName);
				empResponse.setProjectName(prjName);

				employeeApiResponse.setResult(empResponse);
				employeeApiResponse.setStatus(Constants.STATUS_SUCCESS);
				employeeApiResponse.setStatusMessage(Constants.EMP_SUCCESS_STATUS_MSG);
			} else {
				employeeApiResponse.setStatus(Constants.STATUS_SUCCESS);
				employeeApiResponse.setStatusMessage(Constants.EMP_FAILURE_STATUS_MSG);
			}
			logger.info("Ends fetchEmployeeDetailsById({}) ", empId);
		} catch (Exception exp) {
			employeeApiResponse.setStatus(Constants.STATUS_FAILED);
			employeeApiResponse.setStatusMessage(Constants.EMP_EXP_STATUS_MSG);
			logger.error("Exception in fetchEmployeeDetailsById.", exp);
		}
		return employeeApiResponse;
	}

	@Override
	public OrganizationApiResponse<String> dissociateEmployeeFromProject(String empId, String prjId) {
		var employeeApiResponse = new OrganizationApiResponse<String>();
		try {
			logger.info("Starts dissociateEmployeeFromProject({},{}) ", empId, prjId);
			var emp = employeeDetailsRepo.findByEmployeeIdAndProjectProjectId(empId, prjId);
			var project = emp.getProject();
			project.forEach(p -> {
				if (p.getProjectId().equals(prjId) && p.getEmployeeId().equals(empId)) {
					p.setEmployeeId(null);
				}
			});
			employeeDetailsRepo.save(emp);
			employeeApiResponse.setStatus(Constants.STATUS_SUCCESS);
			employeeApiResponse.setStatusMessage(Constants.EMP_DISSOCIATE_STATUS_MSG);
			employeeApiResponse
					.setResult("Successfully dissociated employee with id:" + empId + " from the project id:" + prjId);
			logger.info("Ends dissociateEmployeeFromProject({},{}) ", empId, prjId);
		} catch (Exception exp) {
			employeeApiResponse.setStatus(Constants.STATUS_FAILED);
			employeeApiResponse.setStatusMessage(Constants.EMP_DISSOCIATE_EXP_STATUS_MSG);
			logger.error("Exception in dissociateEmployeeFromProject.", exp);
		}
		return employeeApiResponse;
	}

}
