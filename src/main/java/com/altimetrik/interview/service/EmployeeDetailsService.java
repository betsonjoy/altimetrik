package com.altimetrik.interview.service;

import com.altimetrik.interview.handler.OrganizationApiResponse;
import com.altimetrik.interview.model.EmployeeResponse;

public interface EmployeeDetailsService {

	public OrganizationApiResponse<EmployeeResponse> fetchEmployeeDetailsById(String empId);
	
	public OrganizationApiResponse<String> dissociateEmployeeFromProject(String empId, String prjId);
}
