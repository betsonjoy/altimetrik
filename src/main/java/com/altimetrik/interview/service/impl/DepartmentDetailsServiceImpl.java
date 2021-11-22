package com.altimetrik.interview.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.interview.handler.OrganizationApiResponse;
import com.altimetrik.interview.model.Department;
import com.altimetrik.interview.model.DepartmentResponse;
import com.altimetrik.interview.repository.DepartmentDetailsRepository;
import com.altimetrik.interview.repository.EmployeeDetailsRepository;
import com.altimetrik.interview.service.DepartmentDetailsService;
import com.altimetrik.interview.util.Constants;

@Service
public class DepartmentDetailsServiceImpl implements DepartmentDetailsService {
	Logger logger = LoggerFactory.getLogger(DepartmentDetailsServiceImpl.class);

	@Autowired
	DepartmentDetailsRepository depRepo;

	@Autowired
	EmployeeDetailsRepository employeeRepo;

	@Override
	public OrganizationApiResponse<DepartmentResponse> fetchDepartmentDetailsById(String depId) {
		var departmentApiResponse = new OrganizationApiResponse<DepartmentResponse>();
		var depResponse = new DepartmentResponse();
		var prjName = new ArrayList<String>();
		try {
			logger.info("Starts fetchDepartmentDetailsById({}) ", depId);
			Optional<Department> depOpt = depRepo.findById(depId);
			if (!depOpt.isEmpty()) {
				var dep = depOpt.get();

				depResponse.setDepartmentId(dep.getDepartmentId());
				depResponse.setDepartmentName(dep.getDepartmentName());
				depResponse.setEmployeeName(employeeRepo.getById(dep.getEmployeeId()).getEmployeeName());
				dep.getProject().stream().forEach(p->{
					prjName.add(p.getProjectName());
				});
				depResponse.setProjectName(prjName);
				
				departmentApiResponse.setResult(depResponse);
				departmentApiResponse.setStatus(Constants.STATUS_SUCCESS);
				departmentApiResponse.setStatusMessage(Constants.DEP_SUCCESS_STATUS_MSG);
			} else {
				departmentApiResponse.setStatus(Constants.STATUS_SUCCESS);
				departmentApiResponse.setStatusMessage(Constants.DEP_FAILURE_STATUS_MSG);
			}
			logger.info("Ends fetchDepartmentDetailsById({})", depId);
		} catch (Exception exp) {
			departmentApiResponse.setStatus(Constants.STATUS_FAILED);
			departmentApiResponse.setStatusMessage(Constants.DEP_EXP_STATUS_MSG);

			logger.error("Exception in fetchDepartmentDetailsById.", exp);
		}
		return departmentApiResponse;
	}

}
